package com.github.enteraname74.mouthpieces.local.model

import com.github.enteraname74.mouthpieces.domain.model.Opening
import kotlinx.serialization.Serializable

@Serializable
enum class LocalOpening(val value: String) {
    Small("small"),
    Medium("medium"),
    Large("large");

    fun toOpening(): Opening =
        when (this) {
            Small -> Opening.Small
            Medium -> Opening.Medium
            Large -> Opening.Large
        }

    companion object {
        fun fromString(value: String): LocalOpening? =
            entries.find { it.value == value }
    }
}