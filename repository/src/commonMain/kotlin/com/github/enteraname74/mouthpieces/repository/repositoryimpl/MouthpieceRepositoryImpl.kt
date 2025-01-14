package com.github.enteraname74.mouthpieces.repository.repositoryimpl

import com.github.enteraname74.mouthpieces.domain.model.Mouthpiece
import com.github.enteraname74.mouthpieces.domain.model.MouthpieceFilter
import com.github.enteraname74.mouthpieces.domain.repository.MouthpieceRepository
import com.github.enteraname74.mouthpieces.repository.datasource.MouthpieceLocalDataSource
import kotlinx.coroutines.flow.Flow

class MouthpieceRepositoryImpl(
    private val mouthpieceLocalDataSource: MouthpieceLocalDataSource,
): MouthpieceRepository {
    override suspend fun getMouthpieces(filter: MouthpieceFilter): Flow<List<Mouthpiece>> =
        mouthpieceLocalDataSource.getMouthpieces(filter)
}