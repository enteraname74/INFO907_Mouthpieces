package com.github.enteraname74.mouthpieces.config.di

import org.koin.dsl.module

val configModule = module {
    includes(
        localDataSourceModule,
        repositoryModule,
    )
}