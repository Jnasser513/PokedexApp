package com.jnasser.pokemon.presentation.pokemon_detail.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.jnasser.core.domain.pokemon.model.PokemonType
import com.jnasser.core.presentation.designsystem.components.PokedexLoading
import com.jnasser.core.presentation.designsystem.theme.PokedexAppTheme
import com.jnasser.pokemon.presentation.R
import com.jnasser.pokemon.presentation.pokemon_detail.model.ImageContainerDataUi

@Composable
fun ImageContainer(
    modifier: Modifier = Modifier,
    imageContainerDataUi: ImageContainerDataUi
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        ImageWithTypes(
            modifier = Modifier.padding(vertical = 15.dp),
            image = imageContainerDataUi.image,
            types = imageContainerDataUi.types
        )
    }
}

@Composable
fun ImageWithTypes(
    modifier: Modifier = Modifier,
    image: String,
    types: List<PokemonType>
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier
                .fillMaxWidth(),
            model = image,
            contentDescription = stringResource(R.string.pokemon),
            error = {
                // TODO("Add error image")
            },
            loading = {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    PokedexLoading()
                }
            }
        )
    }
}

@Preview
@Composable
private fun ImageContainerPreview() {
    PokedexAppTheme {
        ImageContainer(
            imageContainerDataUi = ImageContainerDataUi(
                image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/6.svg",
                types = listOf(
                    PokemonType(
                        1, "Fuego"
                    )
                ),
                weight = "90,5",
                height = "1,7"
            )
        )
    }
}