package com.github.enteraname74.mouthpieces.app.feature.mainpage.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.github.enteraname74.mouthpieces.domain.model.Mouthpiece

@Composable
fun MainPageMouthpieceDetail(
    mouthpiece: Mouthpiece,
    onClose: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        IconButton(
            onClick = onClose,
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineLarge,
                text = mouthpiece.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(Modifier.height(32.dp))

            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                InformationRow(
                    title = "Saxophone",
                    text = mouthpiece.saxophone.value,
                )
                InformationRow(
                    title = "Genre",
                    text = mouthpiece.genre.value,
                )
                InformationRow(
                    title = "Chamber",
                    text = mouthpiece.chamber.value,
                )
                InformationRow(
                    title = "Baffle",
                    text = mouthpiece.baffle.value,
                )
                InformationRow(
                    title = "Opening",
                    text = mouthpiece.opening.value,
                )
                InformationRow(
                    title = "Material",
                    text = mouthpiece.material.value,
                )
            }
        }
    }
}

@Composable
private fun InformationRow(
    title: String,
    text: String,
) {
    Column {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineSmall,
        )
        Text(
            text = text,
        )
    }
}