package com.github.enteraname74.mouthpieces.app.feature.mainpage

interface MainPageFilterListener {
    fun updateSearchQuery(query: String)

    fun updateSaxophone(newValue: String?)

    fun updateGenre(newValue: String?)

    fun updateMaterial(newValue: String?)

    fun updateOpening(newValue: String?)

    fun updateBaffle(newValue: String?)

    fun updateChamber(newValue: String?)
}
