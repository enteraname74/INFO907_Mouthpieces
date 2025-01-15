package com.github.enteraname74.mouthpieces.domain.model

enum class Opening(val value: String) {
    Small("small"),
    Medium("medium"),
    Large("large");

    companion object {
        fun fromString(value: String): Opening? =
            entries.find { it.value == value }
    }
}