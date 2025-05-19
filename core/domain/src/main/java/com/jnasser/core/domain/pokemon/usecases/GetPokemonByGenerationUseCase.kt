package com.jnasser.core.domain.pokemon.usecases

import com.jnasser.core.domain.coroutines.DispatcherProvider
import com.jnasser.core.domain.pokemon.repositories.PokemonRepository
import kotlinx.coroutines.withContext

class GetPokemonByGenerationUseCase(
    private val pokemonRepository: PokemonRepository,
    private val dispatcherProvider: DispatcherProvider
) {

    suspend operator fun invoke(generation: Int) = withContext(dispatcherProvider.io) {
        pokemonRepository.getPokemonListByGeneration(generation)
    }
}