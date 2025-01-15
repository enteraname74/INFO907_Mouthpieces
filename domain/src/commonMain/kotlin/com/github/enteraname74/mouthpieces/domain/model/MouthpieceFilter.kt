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
        search: String,
    ): Boolean =
        mouthpiece.genre.value.contains(search)
                || mouthpiece.material.value.contains(search)
                || mouthpiece.saxophone.value.contains(search)
                || mouthpiece.opening.value.contains(search)
                || mouthpiece.baffle.value.contains(search)
                || mouthpiece.chamber.value.contains(search)

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
        val searchValidation = search
            .takeIf { it.isNotEmpty() }
            .validate{
                validateFromSearch(
                    mouthpiece = mouthpiece,
                    search = search,
                )
            }

        return searchValidation && validateFromAttributes(mouthpiece)
    }
}

private fun <T> T?.validate(block: (T) -> Boolean): Boolean =
    this?.let { block(this) } != false
