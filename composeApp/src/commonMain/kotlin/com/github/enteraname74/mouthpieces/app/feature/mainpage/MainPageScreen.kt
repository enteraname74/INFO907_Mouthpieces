package com.github.enteraname74.mouthpieces.app.feature.mainpage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import com.github.enteraname74.mouthpieces.app.feature.mainpage.composable.MainPageFilter
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
            onUpdateSearch = screenModel::updateSearchQuery,
        )
    }

    @Composable
    private fun Screen(
        state: MainPageState,
        filterState: MainPageFilterState,
        onUpdateSearch: (newSearch: String) -> Unit,
    ) {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                MainPageSearchBar(filterState, onUpdateSearch)
                MainPageFilter()
            }
        }
    }
}