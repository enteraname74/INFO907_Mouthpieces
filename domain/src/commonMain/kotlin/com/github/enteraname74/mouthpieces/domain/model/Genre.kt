package com.github.enteraname74.mouthpieces.domain.model

enum class Genre(val value: String) {
    Classic("classical"),
    Jazz("jazz"),
    Rock("rock");

    companion object {
        fun fromString(value: String): Genre? =
            entries.find { it.value == value }
    }
}