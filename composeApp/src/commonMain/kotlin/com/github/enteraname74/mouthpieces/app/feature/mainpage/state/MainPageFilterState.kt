package com.github.enteraname74.mouthpieces.app.feature.mainpage.state

import com.github.enteraname74.mouthpieces.domain.model.*

data class MainPageFilterState(
    val search: String = "",
    val saxophone: Saxophone? = null,
    val genre: Genre? = null,
    val material: Material? = null,
    val opening: Opening? = null,
    val baffle: Baffle? = null,
    val chamber: Chamber? = null,
) {
    fun toMouthpieceFilter(): MouthpieceFilter =
        MouthpieceFilter(
            search = search,
            saxophone = saxophone,
            genre = genre,
            material = material,
            opening = opening,
            baffle = baffle,
            chamber = chamber,
        )
}
