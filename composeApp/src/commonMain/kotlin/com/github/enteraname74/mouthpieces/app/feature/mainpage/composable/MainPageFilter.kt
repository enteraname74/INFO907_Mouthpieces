package com.github.enteraname74.mouthpieces.app.feature.mainpage.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.onClick
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MainPageFilter(
    name: String,
    entries: List<String>,
    selectedValue: String?,
    onValueChanged: (value: String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
    ) {
        TextField(
            modifier = Modifier
                .onClick { expanded = true }
                .menuAnchor(
                    type = MenuAnchorType.PrimaryEditable,
                    enabled = true,
                ),
            label = { Text(name) },
            value = selectedValue ?: "",
            onValueChange = {},
            singleLine = true,
            readOnly = true,
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            entries.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        onValueChanged(item)
                        expanded = false
                    },
                    leadingIcon = { Icon(Icons.Outlined.Edit, contentDescription = null) }
                )
            }
        }
    }
}
