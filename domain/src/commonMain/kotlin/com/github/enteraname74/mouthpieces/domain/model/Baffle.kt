package com.github.enteraname74.mouthpieces.domain.model

enum class Baffle(val value: String) {
    Straight("straight"),
    Curved("curved"),
    Step("step");

    companion object {
        fun fromString(value: String): Baffle? =
            entries.find { it.value == value }
    }
}