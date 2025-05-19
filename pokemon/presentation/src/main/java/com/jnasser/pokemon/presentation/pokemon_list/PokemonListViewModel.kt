package com.jnasser.pokemon.presentation.pokemon_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.jnasser.pokemon.presentation.pokemon_list.model.PokemonDataUi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class PokemonListViewModel(

): ViewModel() {

    var state by mutableStateOf(PokemonListViewState())
        private set

    init {
        state = state.copy(
            pokemonList = listOf(
                PokemonDataUi(
                    name = "Aron",
                    number = "304",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
                ),
                PokemonDataUi(
                    name = "Pikachu",
                    number = "30",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
                ),
                PokemonDataUi(
                    name = "Charizard",
                    number = "302",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
                ),
                PokemonDataUi(
                    name = "Charmander",
                    number = "305",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
                ),
                PokemonDataUi(
                    name = "Charmeleon",
                    number = "307",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
                ),
                PokemonDataUi(
                    name = "Charmeleon",
                    number = "307",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
                ),
                PokemonDataUi(
                    name = "Charmeleon",
                    number = "307",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
                ),
                PokemonDataUi(
                    name = "Charmeleon",
                    number = "307",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
                ),
                PokemonDataUi(
                    name = "Charmeleon",
                    number = "307",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
                ),
                PokemonDataUi(
                    name = "Charmeleon",
                    number = "307",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
                ),
                PokemonDataUi(
                    name = "Charmeleon",
                    number = "307",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
                ),
                PokemonDataUi(
                    name = "Charmeleon",
                    number = "307",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
                ),
                PokemonDataUi(
                    name = "Charmeleon",
                    number = "307",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
                ),
                PokemonDataUi(
                    name = "Charmeleon",
                    number = "307",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
                ),
                PokemonDataUi(
                    name = "Charmeleon",
                    number = "307",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
                )
            )
        )
    }

    private val eventChannel = Channel<PokemonListEvent>()
    val events = eventChannel.receiveAsFlow()

    fun onAction(action: PokemonListAction) {
        when(action) {
            is PokemonListAction.OnPokemonDetail -> TODO()
            is PokemonListAction.OnSearch -> onSearch(action.query)
        }
    }

    private fun onSearch(query: String) {
        state = state.copy(searchQuery = query)
    }
}