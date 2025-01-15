package com.github.enteraname74.mouthpieces.domain.model

enum class Chamber(val value: String) {
    Horseshoe("horseshoe"),
    Round("round");

    companion object {
        fun fromString(value: String): Chamber? =
            entries.find { it.value == value }
    }
}