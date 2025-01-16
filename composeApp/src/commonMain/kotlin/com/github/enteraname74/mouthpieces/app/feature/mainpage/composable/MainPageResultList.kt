package com.github.enteraname74.mouthpieces.app.feature.mainpage.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.github.enteraname74.mouthpieces.domain.model.Mouthpiece

@Composable
fun MainPageResultList(
    mouthpieces: List<Mouthpiece>
) {
    LazyColumn {
        items(
            items = mouthpieces
        ) {
            Text(it.name)
        }
    }
}