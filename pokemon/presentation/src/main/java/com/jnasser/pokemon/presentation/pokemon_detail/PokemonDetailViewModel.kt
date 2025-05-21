package com.jnasser.pokemon.presentation.pokemon_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class PokemonDetailViewModel(

): ViewModel() {

    var state by mutableStateOf(PokemonDetailViewState())
        private set

    private val eventChannel = Channel<PokemonDetailEvent>()
    val events = eventChannel.receiveAsFlow()
}