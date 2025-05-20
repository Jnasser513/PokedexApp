package com.jnasser.pokemon.network.mappers

import com.jnasser.core.domain.pokemon.model.PokemonGenerationDetail
import com.jnasser.core.domain.pokemon.model.PokemonGeneration
import com.jnasser.pokemon.network.model.PokemonDto
import com.jnasser.pokemon.network.model.PokemonGenerationDto

fun List<PokemonDto>.toPokemonList() = map(PokemonDto::toPokemon)

fun PokemonGenerationDto.toPokemonGeneration() = PokemonGeneration(
    pokemonGenerationDetailSpecies = pokemonSpecies.toPokemonList()
)

fun PokemonDto.toPokemon() = PokemonGenerationDetail(
    name = name,
    url = url
)