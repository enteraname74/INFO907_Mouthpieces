package com.github.enteraname74.mouthpieces.app.feature.mainpage.composable

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo
import com.github.enteraname74.mouthpieces.app.ext.disableFocus

@Composable
fun ModalDrawerSheet(
    modifier: Modifier = Modifier,
    drawerContent: @Composable () -> Unit,
    isDrawerShown: Boolean,
    onDismiss: () -> Unit,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier,
    ) {
        content()
        Drawer(
            isShown = isDrawerShown,
            onClose = onDismiss,
        ) {
            drawerContent()
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun BoxScope.Drawer(
    isShown: Boolean,
    onClose: () -> Unit,
    content: @Composable () -> Unit
) {
    val closedValue = LocalWindowInfo.current.containerSize.width

    AnimatedVisibility(
        visible = isShown,
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        Scrim(onClose = onClose)
    }
    AnimatedVisibility(
        modifier = Modifier
            .align(Alignment.TopEnd)
            .disableFocus(),
        visible = isShown,
        enter = slideInHorizontally(
            initialOffsetX = { closedValue },
            animationSpec = tween(durationMillis = 300)
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { closedValue },
            animationSpec = tween(durationMillis = 300),
        )
    ) {
        DrawerHolder {
            content()
        }
    }
}

@Composable
fun DrawerHolder(
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(.4f)
            .background(color = MaterialTheme.colorScheme.surface),
    ) {
        content()
    }
}