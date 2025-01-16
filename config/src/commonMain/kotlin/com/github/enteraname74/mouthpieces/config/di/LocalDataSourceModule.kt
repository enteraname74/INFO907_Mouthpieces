package com.github.enteraname74.mouthpieces.config.di

import com.github.enteraname74.mouthpieces.local.data.JsonParser
import com.github.enteraname74.mouthpieces.local.datasourceimpl.MouthpieceLocalDataSourceImpl
import com.github.enteraname74.mouthpieces.repository.datasource.MouthpieceLocalDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val localDataSourceModule = module {
    singleOf(::MouthpieceLocalDataSourceImpl) bind MouthpieceLocalDataSource::class

    singleOf(::JsonParser)
}