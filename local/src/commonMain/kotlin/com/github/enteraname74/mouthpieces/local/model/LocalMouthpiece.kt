package com.github.enteraname74.mouthpieces.local.model

import com.github.enteraname74.mouthpieces.domain.model.Mouthpiece
import kotlinx.serialization.Serializable

@Serializable
data class LocalMouthpiece(
    val name: String,
) {
    fun toMouthpiece(): Mouthpiece =
        Mouthpiece(
            name = name,
        )
}
