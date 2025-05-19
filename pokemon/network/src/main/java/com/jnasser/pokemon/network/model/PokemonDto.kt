package com.jnasser.pokemon.network.model

import kotlinx.serialization.Serializable

@Serializable
data class PokemonDto(
    val name: String,
    val url: String
)
