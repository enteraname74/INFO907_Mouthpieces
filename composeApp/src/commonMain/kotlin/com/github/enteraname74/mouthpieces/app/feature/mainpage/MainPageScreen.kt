package com.github.enteraname74.mouthpieces.app.feature.mainpage

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import com.github.enteraname74.mouthpieces.app.feature.mainpage.composable.MainPageFilters
import com.github.enteraname74.mouthpieces.app.feature.mainpage.composable.MainPageResultList
import com.github.enteraname74.mouthpieces.app.feature.mainpage.composable.MainPageSearchBar
import com.github.enteraname74.mouthpieces.app.feature.mainpage.state.MainPageFilterState
import com.github.enteraname74.mouthpieces.app.feature.mainpage.state.MainPageState

class MainPageScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = koinScreenModel<MainPageScreenModel>()

        val state: MainPageState by screenModel.state.collectAsState()
        val filterState: MainPageFilterState by screenModel.filterState.collectAsState()

        Screen(
            state = state,
            filterState = filterState,
            filterListener = screenModel,
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun Screen(
        state: MainPageState,
        filterState: MainPageFilterState,
        filterListener: MainPageFilterListener,
    ) {
        Scaffold(
            topBar = { TopAppBar(title = { Text("Mouthpieces") }) }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize().padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                MainPageSearchBar(filterState, filterListener::updateSearchQuery)

                Spacer(Modifier.height(12.dp))

                MainPageFilters(filterState = filterState, filterListener = filterListener)

                Spacer(Modifier.height(12.dp))

                when (state) {
                    is MainPageState.Data -> {
                        MainPageResultList(
                            mouthpieces = state.mouthpieces,
                        )
                    }

                    MainPageState.Loading -> {
                        /*no-op*/
                    }
                }
            }
        }
    }
}
