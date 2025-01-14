package com.github.enteraname74.mouthpieces.app

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.github.enteraname74.mouthpieces.app.di.screenModelModule
import com.github.enteraname74.mouthpieces.app.feature.mainpage.MainPageScreen
import com.github.enteraname74.mouthpieces.app.theme.AppTheme
import com.github.enteraname74.mouthpieces.config.di.configModule
import org.koin.compose.KoinApplication

@Composable
internal fun MouthpiecesApp() = AppTheme {
    KoinApplication(
        application = {
            modules(
                configModule,
                screenModelModule,
            )
        }
    ) {
        Navigator(MainPageScreen())
    }
}
