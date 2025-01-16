package com.github.enteraname74.mouthpieces.app.ext

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics

fun Modifier.clickableWithHandCursor(onClick: () -> Unit): Modifier =
    this
        .pointerHoverIcon(PointerIcon.Hand)
        .clickable(onClick = onClick)

fun Modifier.disableFocus() = this
    .pointerInput(Unit) { detectTapGestures {  } }
    .semantics(mergeDescendants = true) {
        contentDescription = ""
        onClick { true }
    }
    .onKeyEvent { true }