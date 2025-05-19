package com.jnasser.pokemon.presentation.pokemon_list

import com.jnasser.pokemon.presentation.pokemon_list.model.PokemonDataUi

data class PokemonListViewState(
    val isLoading: Boolean = true,
    val pokemonList: List<PokemonDataUi> = emptyList(),
    val searchQuery: String = ""
) {
    val filteredPokemonList: List<PokemonDataUi>
        get() = if(searchQuery.isBlank()) pokemonList
                else pokemonList.filter {
                    it.name.contains(searchQuery.trim(), ignoreCase = true) ||
                    it.number.contains(searchQuery.trim(), ignoreCase = true)
                }
}