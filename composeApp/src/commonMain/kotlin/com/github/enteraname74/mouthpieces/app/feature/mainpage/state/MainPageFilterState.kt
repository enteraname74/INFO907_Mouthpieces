package com.github.enteraname74.mouthpieces.app.feature.mainpage.state

import com.github.enteraname74.mouthpieces.domain.model.MouthpieceFilter

data class MainPageFilterState(
    val name: String = "",
) {
    fun toMouthpieceFilter(): MouthpieceFilter  =
        MouthpieceFilter(search = name)
}
