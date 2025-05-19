package com.jnasser.pokemon.network.mappers

import com.jnasser.core.domain.pokemon.model.Pokemon
import com.jnasser.core.domain.pokemon.model.PokemonGeneration
import com.jnasser.pokemon.network.model.PokemonDto
import com.jnasser.pokemon.network.model.PokemonGenerationDto

fun List<PokemonDto>.toPokemonList() = map(PokemonDto::toPokemon)

fun PokemonGenerationDto.toPokemonGeneration() = PokemonGeneration(
    pokemonSpecies = pokemonSpecies.toPokemonList()
)

fun PokemonDto.toPokemon() = Pokemon(
    name = name,
    url = url
)