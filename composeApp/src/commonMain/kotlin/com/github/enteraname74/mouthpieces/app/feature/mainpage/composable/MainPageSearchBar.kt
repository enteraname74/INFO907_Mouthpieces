package com.github.enteraname74.mouthpieces.app.feature.mainpage.composable

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.github.enteraname74.mouthpieces.app.feature.mainpage.state.MainPageFilterState
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MainPageSearchBar(filterState: MainPageFilterState, onUpdateSearch: (newSearch: String) -> Unit) {
    OutlinedTextField(
        value = filterState.name,
        onValueChange = onUpdateSearch,
        singleLine = true,
        label = {
            Text(
                text = "Find a mouthpiece",
            )
        }
    )
}

@Preview
@Composable
fun MainPageSearchBarPreview() {
    MainPageSearchBar(MainPageFilterState(""), {})
}