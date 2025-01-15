package com.github.enteraname74.mouthpieces.local.model

import com.github.enteraname74.mouthpieces.domain.model.Chamber
import kotlinx.serialization.Serializable

@Serializable
enum class LocalChamber(val value: String) {
    Horseshoe("horseshoe"),
    Round("round");

    fun toChamber(): Chamber =
        when (this) {
            Horseshoe -> Chamber.Horseshoe
            Round -> Chamber.Round
        }

    companion object {
        fun fromString(value: String): LocalChamber? =
            entries.find { it.value == value }
    }
}