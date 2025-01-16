package com.github.enteraname74.mouthpieces.app.feature.mainpage.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.github.enteraname74.mouthpieces.app.ext.clickableWithHandCursor
import com.github.enteraname74.mouthpieces.domain.model.Mouthpiece

@Composable
fun MainPageResultItem(
    mouthpiece: Mouthpiece,
    onClick: (Mouthpiece) -> Unit,
) {
    ElevatedCard(
        modifier = Modifier
            .width(250.dp)
            .clickableWithHandCursor {
                onClick(mouthpiece)
            },
    ) {
        Box(Modifier.fillMaxSize().padding(12.dp)) {
            Column {
                Text(
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall,
                    text = mouthpiece.name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(Modifier.height(12.dp))

                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text("Saxophone : " + mouthpiece.saxophone.value)
                    Text("Genre : " + mouthpiece.genre.value)
                    Text("Chamber : " + mouthpiece.chamber)
                    Text("Baffle : " + mouthpiece.baffle)
                }
            }
        }
    }
}
