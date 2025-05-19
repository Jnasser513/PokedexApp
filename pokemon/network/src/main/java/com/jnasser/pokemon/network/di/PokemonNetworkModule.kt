package com.jnasser.pokemon.network.di

import com.jnasser.core.domain.pokemon.datasources.RemotePokemonDataSource
import com.jnasser.pokemon.network.datasources.KtorPokemonDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val pokemonNetworkModule = module {
    singleOf(::KtorPokemonDataSource).bind<RemotePokemonDataSource>()
}