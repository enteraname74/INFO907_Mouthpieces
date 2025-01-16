package com.github.enteraname74.mouthpieces.app.feature.mainpage

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.github.enteraname74.mouthpieces.app.feature.mainpage.state.MainPageFilterState
import com.github.enteraname74.mouthpieces.app.feature.mainpage.state.MainPageState
import com.github.enteraname74.mouthpieces.domain.model.*
import com.github.enteraname74.mouthpieces.domain.repository.MouthpieceRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

class MainPageScreenModel(
    private val mouthpieceRepository: MouthpieceRepository,
) : ScreenModel, MainPageFilterListener {
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

    override fun updateSearchQuery(query: String) {
        _filterState.update {
            it.copy(search = query)
        }
    }

    override fun updateSaxophone(newValue: String) {
        _filterState.update {
            it.copy(saxophone = Saxophone.fromString(newValue))
        }
    }

    override fun updateGenre(newValue: String) {
        _filterState.update {
            it.copy(genre = Genre.fromString(newValue))
        }
    }

    override fun updateMaterial(newValue: String) {
        _filterState.update {
            it.copy(material = Material.fromString(newValue))
        }
    }

    override fun updateOpening(newValue: String) {
        _filterState.update {
            it.copy(opening = Opening.fromString(newValue))
        }
    }

    override fun updateBaffle(newValue: String) {
        _filterState.update {
            it.copy(baffle = Baffle.fromString(newValue))
        }
    }

    override fun updateChamber(newValue: String) {
        _filterState.update {
            it.copy(chamber = Chamber.fromString(newValue))
        }
    }
}
