package com.jnasser.pokemon.presentation.di

import com.jnasser.pokemon.presentation.pokemon_list.PokemonListViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val pokemonPresentationModule = module {
    singleOf(::PokemonListViewModel)
}