package com.github.enteraname74.mouthpieces.domain.model

data class MouthpieceFilter(
    val search: String = "",
    val saxophone: Saxophone? = null,
    val genre: Genre? = null,
    val material: Material? = null,
    val opening: Opening? = null,
    val baffle: Baffle? = null,
    val chamber: Chamber? = null,
) {

    private fun validateFromSearch(
        mouthpiece: Mouthpiece,
    ): Boolean =
        search
            .takeIf { it.isNotBlank() }
            .validate { validatedSearch ->
                validatedSearch
                    .lowercase()
                    .split(" ")
                    .map { entry ->
                        validateFromSearchEntry(
                            mouthpiece = mouthpiece,
                            search = entry.trim(),
                        )
                    }.all { it }
            }


    private fun validateFromSearchEntry(
        mouthpiece: Mouthpiece,
        search: String,
    ): Boolean =
        mouthpiece.genre.value.lowercase().contains(search)
                || mouthpiece.material.value.lowercase().contains(search)
                || mouthpiece.saxophone.value.lowercase().contains(search)
                || mouthpiece.opening.value.lowercase().contains(search)
                || mouthpiece.baffle.value.lowercase().contains(search)
                || mouthpiece.chamber.value.lowercase().contains(search)
                || mouthpiece.name.lowercase().contains(search)

    private fun validateFromAttributes(
        mouthpiece: Mouthpiece
    ): Boolean =
        saxophone.validate { mouthpiece.saxophone == it }
                && genre.validate { mouthpiece.genre == it }
                && material.validate { mouthpiece.material == it }
                && opening.validate { mouthpiece.opening == it }
                && baffle.validate { mouthpiece.baffle == it }
                && chamber.validate { mouthpiece.chamber == it }

    fun validateMouthpiece(mouthpiece: Mouthpiece): Boolean {
        return validateFromSearch(mouthpiece) && validateFromAttributes(mouthpiece)
    }
}

private fun <T> T?.validate(block: (T) -> Boolean): Boolean =
    this?.let { block(this) } != false
