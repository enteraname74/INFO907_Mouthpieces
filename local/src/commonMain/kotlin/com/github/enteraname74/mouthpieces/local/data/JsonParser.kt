package com.github.enteraname74.mouthpieces.local.data

import com.github.enteraname74.mouthpieces.domain.model.Mouthpiece

class JsonParser(
    val json: String,
) {
    var data: List<Mouthpiece>
}