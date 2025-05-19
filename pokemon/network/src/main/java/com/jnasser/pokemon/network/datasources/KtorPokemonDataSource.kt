package com.jnasser.pokemon.network.datasources

import com.jnasser.core.data.networking.get
import com.jnasser.core.domain.pokemon.datasources.RemotePokemonDataSource
import com.jnasser.core.domain.pokemon.model.PokemonGeneration
import com.jnasser.core.domain.util.error_handler.DataError
import com.jnasser.core.domain.util.result_handler.Result
import com.jnasser.core.domain.util.result_handler.map
import com.jnasser.pokemon.network.mappers.toPokemonGeneration
import com.jnasser.pokemon.network.model.PokemonGenerationDto
import io.ktor.client.HttpClient

class KtorPokemonDataSource(
    private val httpClient: HttpClient
): RemotePokemonDataSource {

    override suspend fun getPokemonListByGeneration(
        generation: Int
    ): Result<PokemonGeneration, DataError.Network> {
        return httpClient.get<PokemonGenerationDto>(
            route = "generation/$generation"
        ).map { it.toPokemonGeneration() }
    }
}