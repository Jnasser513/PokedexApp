package com.jnasser.core.data.repositories

import com.jnasser.core.domain.pokemon.datasources.LocalPokemonDataSource
import com.jnasser.core.domain.pokemon.datasources.RemotePokemonDataSource
import com.jnasser.core.domain.pokemon.model.Pokemon
import com.jnasser.core.domain.pokemon.model.PokemonGeneration
import com.jnasser.core.domain.pokemon.repositories.PokemonRepository
import com.jnasser.core.domain.util.error_handler.DataError
import com.jnasser.core.domain.util.result_handler.Result
import kotlinx.coroutines.flow.Flow

class OfflineFirstPokemonRepository(
    private val remotePokemonDataSource: RemotePokemonDataSource,
    private val localPokemonDataSource: LocalPokemonDataSource
): PokemonRepository {

    override fun getPokemons(): Flow<List<Pokemon>> = localPokemonDataSource.getPokemons()

    override suspend fun getPokemonListByGeneration(
        generation: Int
    ): Result<PokemonGeneration, DataError> {
        return when(val result = remotePokemonDataSource.getPokemonListByGeneration(generation)) {
            is Result.Error -> Result.Error(result.error)
            is Result.Success -> {

                Result.Success(result.data)
            }
        }
    }
}