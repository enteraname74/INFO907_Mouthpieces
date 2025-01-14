package com.github.enteraname74.mouthpieces.domain.repository

import com.github.enteraname74.mouthpieces.domain.model.Mouthpiece
import com.github.enteraname74.mouthpieces.domain.model.MouthpieceFilter
import kotlinx.coroutines.flow.Flow

interface MouthpieceRepository {
    suspend fun getMouthpieces(
        filter: MouthpieceFilter,
    ): Flow<List<Mouthpiece>>
}