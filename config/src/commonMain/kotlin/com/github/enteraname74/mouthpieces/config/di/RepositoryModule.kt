package com.github.enteraname74.mouthpieces.config.di

import com.github.enteraname74.mouthpieces.domain.repository.MouthpieceRepository
import com.github.enteraname74.mouthpieces.repository.repositoryimpl.MouthpieceRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val repositoryModule = module {
    singleOf(::MouthpieceRepositoryImpl) bind MouthpieceRepository::class
}