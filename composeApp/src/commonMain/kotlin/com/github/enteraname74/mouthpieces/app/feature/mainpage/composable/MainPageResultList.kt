package com.github.enteraname74.mouthpieces.app.feature.mainpage.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.github.enteraname74.mouthpieces.domain.model.Mouthpiece

@Composable
fun MainPageResultList(
    mouthpieces: List<Mouthpiece>,
    onSelectMouthpiece: (Mouthpiece) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 250.dp),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(
            items = mouthpieces
        ) { mouthpiece ->
            MainPageResultItem(
                mouthpiece = mouthpiece,
                onClick = onSelectMouthpiece,
            )
        }
    }
}
