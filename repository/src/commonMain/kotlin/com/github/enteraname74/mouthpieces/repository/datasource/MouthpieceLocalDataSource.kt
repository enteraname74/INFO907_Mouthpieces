package com.github.enteraname74.mouthpieces.repository.datasource

import com.github.enteraname74.mouthpieces.domain.model.Mouthpiece
import com.github.enteraname74.mouthpieces.domain.model.MouthpieceFilter
import kotlinx.coroutines.flow.Flow

interface MouthpieceLocalDataSource {
    suspend fun getMouthpieces(
        filter: MouthpieceFilter,
    ): Flow<List<Mouthpiece>>
}