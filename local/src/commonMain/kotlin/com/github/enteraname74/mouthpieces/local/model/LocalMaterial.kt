package com.github.enteraname74.mouthpieces.local.model

import com.github.enteraname74.mouthpieces.domain.model.Material
import kotlinx.serialization.Serializable

@Serializable
enum class LocalMaterial(val value: String) {
    Ebonite("ebonite"),
    Plastic("plastic"),
    Metal("metal");

    fun toMaterial(): Material =
        when(this) {
            Ebonite -> Material.Ebonite
            Plastic -> Material.Plastic
            Metal -> Material.Metal
        }

    companion object {
        fun fromString(value: String): LocalMaterial? =
            entries.find { it.value == value }
    }
}