package com.github.enteraname74.mouthpieces.app.feature.mainpage.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.onClick
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MainPageFilter() {
    var expanded by remember { mutableStateOf(false) }
    var selectedValue by remember { mutableStateOf("") }

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

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
            label = { Text("TODO") },
            value = selectedValue,
            onValueChange = {},
            singleLine = true,
            readOnly = true,
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            DropdownMenuItem(
                text = { Text("Test 1") },
                onClick = {
                    selectedValue = "Test 1"
                    expanded = false
                },
                leadingIcon = { Icon(Icons.Outlined.Edit, contentDescription = null) }
            )
        }
    }

//    DropdownMenu(
//        expanded = expanded,
//        onDismissRequest = { expanded = false },
//        containerColor = Color.Red,
//    ) {
//
//    }
}

@Composable
@Preview
fun MainPageFilterPreview() {
    MainPageFilter()
}