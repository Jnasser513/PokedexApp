package com.jnasser.pokemon.presentation.pokemon_list.composables

import PokedexScaffold
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jnasser.core.presentation.designsystem.components.PokedexLoading
import com.jnasser.core.presentation.designsystem.components.PokedexSearchBar
import com.jnasser.core.presentation.designsystem.components.PokedexSearchBarConfig
import com.jnasser.core.presentation.designsystem.theme.Montserrat
import com.jnasser.core.presentation.designsystem.theme.PokedexAppTheme
import com.jnasser.core.presentation.designsystem.theme.PokedexIcons
import com.jnasser.pokemon.presentation.R
import com.jnasser.pokemon.presentation.pokemon_list.PokemonListAction
import com.jnasser.pokemon.presentation.pokemon_list.PokemonListViewModel
import com.jnasser.pokemon.presentation.pokemon_list.PokemonListViewState
import com.jnasser.pokemon.presentation.pokemon_list.model.PokemonListDataUi
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber

@Composable
fun PokemonListScreenRoot(
    viewModel: PokemonListViewModel = koinViewModel()
) {
    PokemonListScreen(
        state = viewModel.state,
        onAction = { action ->
            viewModel.onAction(action)
        }
    )
}

@Composable
fun PokemonListScreen(
    state: PokemonListViewState,
    onAction: (PokemonListAction) -> Unit
) {
    PokedexScaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.surface),
        topAppBar = { PokemonListTopBar() }
    ) { padding ->

        val searchBarState = rememberTextFieldState()

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(20.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Normal
                            )
                        ) {
                            append(stringResource(R.string.hello))
                        }
                        append(stringResource(R.string.welcome))
                    },
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(Modifier.height(20.dp))
                PokedexSearchBar(
                    textFieldState = searchBarState,
                    config = PokedexSearchBarConfig(
                        trailingIcon = PokedexIcons.Search,
                        onSearch = { query ->
                            onAction(PokemonListAction.OnSearch(query))
                        }
                    )
                )
                PokemonList(
                    pokemonList = state.filteredPokemonList
                )
            }
        }
    }
}

@Composable
fun PokemonListTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            imageVector = PokedexIcons.PokeBall,
            contentDescription = stringResource(R.string.pokeball),
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = stringResource(R.string.pokedex),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview
@Composable
private fun PokemonListScreenLoadingPreview() {
    PokedexAppTheme {
        PokemonListScreen(
            PokemonListViewState(),
        ) { }
    }
}

@Preview
@Composable
private fun PokemonListScreenPreview() {
    PokedexAppTheme {
        PokemonListScreen(
            PokemonListViewState(isLoading = false),
        ) { }
    }
}