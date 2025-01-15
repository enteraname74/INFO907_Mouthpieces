package com.github.enteraname74.mouthpieces.domain.model

data class Mouthpiece(
    val name: String,
    val saxophone: Saxophone,
    val genre: Genre,
    val material: Material,
    val opening: Opening,
    val baffle: Baffle,
    val chamber: Chamber,
)
