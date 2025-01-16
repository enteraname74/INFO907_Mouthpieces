package com.github.enteraname74.mouthpieces.app.feature.mainpage.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.github.enteraname74.mouthpieces.app.ext.clickableWithHandCursor

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MainPageFilter(
    name: String,
    entries: List<String>,
    selectedValue: String?,
    onValueChanged: (value: String?) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        modifier = Modifier
            .width(260.dp),
        expanded = expanded,
        onExpandedChange = {
            expanded = it
        },
    ) {
        FilterButton(
            onRemove = {
                expanded = false
                onValueChanged(null)
            },
            selectedValue = selectedValue,
            onClick = { expanded = true },
            isExpanded = expanded,
            title = name,
            modifier = Modifier
                .menuAnchor(
                    type = MenuAnchorType.PrimaryNotEditable,
                    enabled = true,
                )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
        ) {
            entries.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        onValueChanged(item)
                        expanded = false
                    },
                )
            }
        }
    }
}

@Composable
private fun FilterButton(
    title: String,
    selectedValue: String?,
    onClick: () -> Unit,
    onRemove: () -> Unit,
    isExpanded: Boolean,
    modifier: Modifier,
) {
    val isRotated by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f
    )

    Row(
        modifier = modifier
            .width(260.dp)
            .height(80.dp)
            .background(
                color = MenuDefaults.containerColor,
                shape = RoundedCornerShape(8.dp),
            )
            .clickableWithHandCursor { onClick() }
            .padding(all = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.SemiBold,
                color = MenuDefaults.itemColors().textColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = selectedValue ?: "--",
                color = MenuDefaults.itemColors().textColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
        AnimatedVisibility(
            visible = selectedValue != null,
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            IconButton(
                onClick = onRemove,
            ) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = null,
                    tint = MenuDefaults.itemColors().textColor
                )
            }
        }
        Icon(
            modifier = Modifier
                .rotate(isRotated),
            imageVector = Icons.Rounded.ArrowDropDown,
            contentDescription = null,
            tint = MenuDefaults.itemColors().textColor
        )
    }
}
