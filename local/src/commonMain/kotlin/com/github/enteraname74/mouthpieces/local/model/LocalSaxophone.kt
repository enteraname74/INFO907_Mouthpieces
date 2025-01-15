package com.github.enteraname74.mouthpieces.local.model

import com.github.enteraname74.mouthpieces.domain.model.Saxophone
import kotlinx.serialization.Serializable

@Serializable
enum class LocalSaxophone(val value: String) {
    Soprano("soprano"),
    Alto("alto"),
    Tenor("tenor"),
    Baryton("baryton");

    fun toSaxophone(): Saxophone =
        when(this) {
            Soprano -> Saxophone.Soprano
            Alto -> Saxophone.Alto
            Tenor -> Saxophone.Tenor
            Baryton -> Saxophone.Baryton
        }

    companion object {
        fun fromString(value: String): LocalSaxophone? =
            entries.find { it.value == value }
    }
}