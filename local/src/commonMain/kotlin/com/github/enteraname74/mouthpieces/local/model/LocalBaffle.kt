package com.github.enteraname74.mouthpieces.local.model

import com.github.enteraname74.mouthpieces.domain.model.Baffle
import kotlinx.serialization.Serializable

@Serializable
enum class LocalBaffle(val value: String) {
    Straight("straight"),
    Curved("curved"),
    Step("step");

    fun toBaffle(): Baffle =
        when(this) {
            Straight -> Baffle.Straight
            Curved -> Baffle.Curved
            Step -> Baffle.Step
        }

    companion object {
        fun fromString(value: String): LocalBaffle? =
            entries.find { it.value == value }
    }
}