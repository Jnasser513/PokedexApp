package com.jnasser.pokemon.presentation.pokemon_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.jnasser.core.domain.pokemon.usecases.GetLocalPokemonByIdUseCase
import com.jnasser.pokemon.presentation.pokemon_detail.mappers.toPokemonDetailDatUi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PokemonDetailViewModel(
    private val getLocalPokemonByIdUseCase: GetLocalPokemonByIdUseCase
): ViewModel() {

    private val scope = CoroutineScope(SupervisorJob())

    var state by mutableStateOf(PokemonDetailViewState())
        private set

    private val eventChannel = Channel<PokemonDetailEvent>()
    val events = eventChannel.receiveAsFlow()

    fun getPokemonById(pokemonId: Int) {
        scope.launch {
            val pokemon = getLocalPokemonByIdUseCase(pokemonId)

            state = state.copy(
                isLoading = false,
                pokemonDetail = pokemon.toPokemonDetailDatUi()
            )
        }
    }

}