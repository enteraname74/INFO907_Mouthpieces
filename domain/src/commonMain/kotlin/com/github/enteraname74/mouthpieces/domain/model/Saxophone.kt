package com.github.enteraname74.mouthpieces.domain.model

enum class Saxophone(val value: String) {
    Soprano("soprano"),
    Alto("alto"),
    Tenor("tenor"),
    Baryton("baryton");

    companion object {
        fun fromString(value: String): Saxophone? =
            entries.find { it.value == value }
    }
}