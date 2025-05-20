@file:OptIn(ExperimentalMaterial3Api::class)

package com.jnasser.pokemon.presentation.pokemon_detail.composables

import PokedexScaffold
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jnasser.core.presentation.designsystem.components.PokedexTopAppBar
import com.jnasser.core.presentation.designsystem.components.PokedexTopAppBarConfig
import com.jnasser.core.presentation.designsystem.theme.PokedexAppTheme
import com.jnasser.core.presentation.designsystem.theme.PokedexColors
import com.jnasser.core.presentation.ui.ObserveAsEvents
import com.jnasser.pokemon.presentation.pokemon_detail.PokemonDetailAction
import com.jnasser.pokemon.presentation.pokemon_detail.PokemonDetailEvent
import com.jnasser.pokemon.presentation.pokemon_detail.PokemonDetailViewModel
import com.jnasser.pokemon.presentation.pokemon_detail.PokemonDetailViewState
import com.jnasser.pokemon.presentation.pokemon_detail.model.PokemonDetailDataUi
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokemonDetailScreenRoot(
    viewModel: PokemonDetailViewModel = koinViewModel()
) {
    val context = LocalContext.current
    ObserveAsEvents(viewModel.events) { event ->
        when(event) {
            is PokemonDetailEvent.Error -> Toast.makeText(
                context,
                event.error.asString(context),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    PokemonDetailScreen(
        state = viewModel.state,
        onAction = { action ->
            viewModel.onAction(action)
        }
    )
}

@Composable
fun PokemonDetailScreen(
    state: PokemonDetailViewState,
    onAction: (PokemonDetailAction) -> Unit
) {
    PokedexScaffold(
        topAppBar = {
            PokedexTopAppBar(
                modifier = Modifier.padding(horizontal = 8.dp),
                config = PokedexTopAppBarConfig(
                    title = "Charizard",
                    centerTitle = false,
                    navigationIcon = PokedexTopAppBar.NavigationIcon.Up {},
                    actions = listOf(
                        PokedexTopAppBar.Action(
                            text = "#006",
                            tintColor = PokedexColors.Gray300
                        )
                    )
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(20.dp)
        ) {
            item {

            }
        }
    }
}

@Preview
@Composable
private fun PokemonDetailScreenPreview() {
    PokedexAppTheme {
        PokemonDetailScreen(
            state = PokemonDetailViewState(
                pokemonDetail = PokemonDetailDataUi(
                    name = "Charizard"
                )
            )
        ) { }
    }
}