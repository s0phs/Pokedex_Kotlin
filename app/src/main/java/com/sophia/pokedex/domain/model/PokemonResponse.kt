package com.sophia.pokedex.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class PokemonResponse (
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val sprites: SpritesResponse
)

@Serializable
data class SpritesResponse(
    @SerialName("front_default")
    val frontDefault: String? = null
)

fun PokemonResponse.toDomain(): Pokemon {
    return Pokemon(
        id = id,
        name = name.replaceFirstChar { it.uppercase() },
        imageUrl = sprites.frontDefault.orEmpty()
    )
}