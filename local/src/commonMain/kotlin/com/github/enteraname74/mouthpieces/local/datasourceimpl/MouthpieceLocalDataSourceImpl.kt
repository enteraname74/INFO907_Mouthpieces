package com.github.enteraname74.mouthpieces.local.datasourceimpl

import com.github.enteraname74.mouthpieces.domain.model.Mouthpiece
import com.github.enteraname74.mouthpieces.domain.model.MouthpieceFilter
import com.github.enteraname74.mouthpieces.local.data.JsonParser
import com.github.enteraname74.mouthpieces.repository.datasource.MouthpieceLocalDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest

class MouthpieceLocalDataSourceImpl(
    private val jsonParser: JsonParser
) : MouthpieceLocalDataSource {
    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun getMouthpieces(filter: MouthpieceFilter): Flow<List<Mouthpiece>> =
        jsonParser.data.mapLatest { list ->
            list
                .map { it.toMouthpiece() }
                .filter { filter.validateMouthpiece(it) }
        }
}