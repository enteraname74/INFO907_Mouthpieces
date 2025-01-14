package com.github.enteraname74.mouthpieces.app.di

import com.github.enteraname74.mouthpieces.app.feature.mainpage.MainPageScreenModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val screenModelModule = module {
    factoryOf(::MainPageScreenModel)
}