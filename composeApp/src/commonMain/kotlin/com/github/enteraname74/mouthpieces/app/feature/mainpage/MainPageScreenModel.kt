package com.github.enteraname74.mouthpieces.app.feature.mainpage

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import cafe.adriel.voyager.core.registry.screenModule
import com.github.enteraname74.mouthpieces.app.feature.mainpage.state.MainPageFilterState
import com.github.enteraname74.mouthpieces.app.feature.mainpage.state.MainPageState
import com.github.enteraname74.mouthpieces.domain.repository.MouthpieceRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class MainPageScreenModel(
    private val mouthpieceRepository: MouthpieceRepository,
) : ScreenModel {
    private val _filterState: MutableStateFlow<MainPageFilterState> = MutableStateFlow(
        MainPageFilterState()
    )
    val filterState: StateFlow<MainPageFilterState> = _filterState.asStateFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    val state: StateFlow<MainPageState> = _filterState.flatMapLatest { filterState ->
        mouthpieceRepository.getMouthpieces(
            filter = filterState.toMouthpieceFilter()
        ).mapLatest { mouthpieces ->
            MainPageState.Data(
                mouthpieces = mouthpieces,
            )
        }
    }.stateIn(
        scope = screenModelScope,
        started = SharingStarted.Eagerly,
        initialValue = MainPageState.Loading,
    )

    fun updateNameQuery(query: String) {
        _filterState.update {
            it.copy(name = query)
        }
    }
}