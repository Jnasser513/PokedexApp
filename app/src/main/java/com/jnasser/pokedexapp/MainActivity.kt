package com.jnasser.pokedexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jnasser.core.presentation.designsystem.theme.PokedexAppTheme
import com.jnasser.pokemon.presentation.pokemon_detail.composables.PokemonDetailScreenRoot
import com.jnasser.pokemon.presentation.pokemon_list.composables.PokemonListScreenRoot

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexAppTheme {
                PokemonDetailScreenRoot()
            }
        }
    }
}