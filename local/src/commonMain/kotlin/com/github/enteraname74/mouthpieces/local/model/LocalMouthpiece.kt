package com.github.enteraname74.mouthpieces.local.model

import com.github.enteraname74.mouthpieces.domain.model.Mouthpiece
import kotlinx.serialization.Serializable

@Serializable
data class LocalMouthpiece(
    val name: String,
    val saxophone: LocalSaxophone,
    val genre: LocalGenre,
    val material: LocalMaterial,
    val opening: LocalOpening,
    val chamber: LocalChamber,
    val baffle: LocalBaffle,
) {
    fun toMouthpiece(): Mouthpiece =
        Mouthpiece(
            name = name,
            saxophone = saxophone.toSaxophone(),
            genre = genre.toGenre(),
            material = material.toMaterial(),
            opening = opening.toOpening(),
            chamber = chamber.toChamber(),
            baffle = baffle.toBaffle(),
        )

}
