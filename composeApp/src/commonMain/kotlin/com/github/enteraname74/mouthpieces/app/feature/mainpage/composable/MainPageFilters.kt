package com.github.enteraname74.mouthpieces.app.feature.mainpage.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.github.enteraname74.mouthpieces.app.feature.mainpage.MainPageFilterListener
import com.github.enteraname74.mouthpieces.app.feature.mainpage.state.MainPageFilterState
import com.github.enteraname74.mouthpieces.domain.model.*

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainPageFilters(filterState: MainPageFilterState, filterListener: MainPageFilterListener) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        MainPageFilter(
            name = "Saxophone",
            entries = Saxophone.entries.map { it.value }.toList(),
            selectedValue = filterState.saxophone?.value,
            onValueChanged = filterListener::updateSaxophone,
        )
        MainPageFilter(
            name = "Genre", entries = Genre.entries.map { it.value }.toList(),
            selectedValue = filterState.genre?.value,
            onValueChanged = filterListener::updateGenre,
        )
        MainPageFilter(
            name = "Material", entries = Material.entries.map { it.value }.toList(),
            selectedValue = filterState.material?.value,
            onValueChanged = filterListener::updateMaterial,
        )
        MainPageFilter(
            name = "Opening", entries = Opening.entries.map { it.value }.toList(),
            selectedValue = filterState.opening?.value,
            onValueChanged = filterListener::updateOpening,
        )
        MainPageFilter(
            name = "Baffle", entries = Baffle.entries.map { it.value }.toList(),
            selectedValue = filterState.baffle?.value,
            onValueChanged = filterListener::updateBaffle,
        )
        MainPageFilter(
            name = "Chamber", entries = Chamber.entries.map { it.value }.toList(),
            selectedValue = filterState.chamber?.value,
            onValueChanged = filterListener::updateChamber,
        )
    }
}
