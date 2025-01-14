package com.github.enteraname74.mouthpieces.app.feature.mainpage.state

import com.github.enteraname74.mouthpieces.domain.model.Mouthpiece

sealed interface MainPageState {
    data object Loading : MainPageState
    data class Data(
        val mouthpieces: List<Mouthpiece>
    ): MainPageState
}