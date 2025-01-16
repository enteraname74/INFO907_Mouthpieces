package com.github.enteraname74.mouthpieces.app.feature.mainpage.composable

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.github.enteraname74.mouthpieces.app.feature.mainpage.state.MainPageFilterState

@Composable
fun MainPageSearchBar(filterState: MainPageFilterState, onUpdateSearch: (newSearch: String) -> Unit) {
    OutlinedTextField(
        value = filterState.search,
        onValueChange = onUpdateSearch,
        singleLine = true,
        label = {
            Text(
                text = "Find a mouthpiece",
            )
        }
    )
}
