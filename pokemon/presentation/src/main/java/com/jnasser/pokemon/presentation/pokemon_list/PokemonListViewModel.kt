package com.jnasser.pokemon.presentation.pokemon_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class PokemonListViewModel(

): ViewModel() {

    var state by mutableStateOf(PokemonListViewState())
        private set

    private val eventChannel = Channel<PokemonListEvent>()
    val events = eventChannel.receiveAsFlow()

    fun onAction(action: PokemonListAction) {
        when(action) {
            is PokemonListAction.OnPokemonDetail -> TODO()
            is PokemonListAction.OnSearch -> TODO()
        }
    }
}