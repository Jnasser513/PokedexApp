package com.jnasser.core.domain.pokemon.usecases

import com.jnasser.core.domain.pokemon.repositories.PokemonRepository

class GetLocalPokemonByIdUseCase(
    private val repository: PokemonRepository
) {

    operator fun invoke(pokemonId: Int) = repository.getPokemonById(pokemonId)
}