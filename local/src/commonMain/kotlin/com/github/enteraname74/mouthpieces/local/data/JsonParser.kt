package com.github.enteraname74.mouthpieces.local.data

import com.github.enteraname74.mouthpieces.domain.model.Genre
import com.github.enteraname74.mouthpieces.domain.model.Mouthpiece
import com.github.enteraname74.mouthpieces.domain.model.Saxophone
import com.github.enteraname74.mouthpieces.local.model.LocalBaffle
import com.github.enteraname74.mouthpieces.local.model.LocalChamber
import com.github.enteraname74.mouthpieces.local.model.LocalGenre
import com.github.enteraname74.mouthpieces.local.model.LocalMaterial
import com.github.enteraname74.mouthpieces.local.model.LocalMouthpiece
import com.github.enteraname74.mouthpieces.local.model.LocalOpening
import com.github.enteraname74.mouthpieces.local.model.LocalSaxophone
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject

class JsonParser {
    private val _data: MutableStateFlow<List<LocalMouthpiece>> = MutableStateFlow(emptyList())
    val data: Flow<List<LocalMouthpiece>> = _data

    init {
        val flattenedData: List<FlattenedData> = flattenData(
            jsonElement = Json.parseToJsonElement(JsonData),
            attributes = emptyList(),
        )

        _data.value = buildList {
            flattenedData.forEach { dataItem ->
                addAll(
                    dataItem.toMouthpieces()
                )
            }
        }
    }

    private fun flattenData(
        jsonElement: JsonElement,
        attributes: List<String>
    ): List<FlattenedData> = buildList {
        when (jsonElement) {
            is JsonObject -> {
                jsonElement.entries.forEach { entry ->
                    addAll(
                        flattenData(
                            jsonElement = entry.value,
                            attributes = attributes + entry.key
                        )
                    )
                }
            }
            is JsonArray -> {
                println("-----------")
                println("Got leaf from top? $jsonElement")
                attributes.forEach {
                    println(it)
                }
                add(
                    FlattenedData(
                        attributes = attributes,
                        mouthpiecesNames = jsonElement.map { it.toString() },
                    )
                )
            }
            else -> {
                println("What to do here?")
            }
        }
    }
}

private data class FlattenedData(
    val attributes: List<String>,
    val mouthpiecesNames: List<String>,
) {
    var mapAttributes: Map<String, String> =
        attributes.chunked(2) { it[0] to it[1] }.toMap()

    private fun getSaxophone(): LocalSaxophone =
        mapAttributes["Saxophone"]?.let { LocalSaxophone.fromString(it) } ?: LocalSaxophone.Alto


    private fun getGenre(): LocalGenre =
        mapAttributes["Genre"]?.let { LocalGenre.fromString(it) } ?: LocalGenre.Jazz

    private fun getMaterial(): LocalMaterial =
        mapAttributes["Material"]?.let { LocalMaterial.fromString(it) } ?: LocalMaterial.Ebonite

    private fun getOpening(): LocalOpening =
        mapAttributes["Opening"]?.let { LocalOpening.fromString(it) } ?: LocalOpening.Medium

    private fun getChamber(): LocalChamber =
        mapAttributes["Chamber"]?.let { LocalChamber.fromString(it) } ?: LocalChamber.Round

    private fun getBaffle(): LocalBaffle =
        mapAttributes["Baffle"]?.let { LocalBaffle.fromString(it) } ?: LocalBaffle.Straight

    fun toMouthpieces(): List<LocalMouthpiece> =
        mouthpiecesNames.map { name ->
            LocalMouthpiece(
                name = name,
                saxophone = getSaxophone(),
                genre = getGenre(),
                material = getMaterial(),
                opening = getOpening(),
                chamber = getChamber(),
                baffle = getBaffle(),
            )
        }
}