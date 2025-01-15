package com.github.enteraname74.mouthpieces.domain.model

enum class Material(val value: String) {
    Ebonite("ebonite"),
    Plastic("plastic"),
    Metal("metal");

    companion object {
        fun fromString(value: String): Material? =
            entries.find { it.value == value }
    }
}