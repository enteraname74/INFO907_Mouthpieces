package com.github.enteraname74.mouthpieces.local.model

import com.github.enteraname74.mouthpieces.domain.model.Genre
import kotlinx.serialization.Serializable

@Serializable
enum class LocalGenre(val value: String) {
    Classic("classical"),
    Jazz("jazz"),
    Rock("rock");

    fun toGenre(): Genre =
        when(this) {
            Classic -> Genre.Classic
            Jazz -> Genre.Jazz
            Rock -> Genre.Rock
        }

    companion object {
        fun fromString(value: String): LocalGenre? =
            entries.find { it.value == value }
    }
}