package com.github.enteraname74.mouthpieces.local.datasourceimpl

import com.github.enteraname74.mouthpieces.domain.model.Mouthpiece
import com.github.enteraname74.mouthpieces.domain.model.MouthpieceFilter
import com.github.enteraname74.mouthpieces.repository.datasource.MouthpieceLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MouthpieceLocalDataSourceImpl: MouthpieceLocalDataSource {
    override suspend fun getMouthpieces(filter: MouthpieceFilter): Flow<List<Mouthpiece>> =
        flowOf(emptyList())
}