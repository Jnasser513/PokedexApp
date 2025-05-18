package com.jnasser.core.presentation.designsystem.theme

import androidx.compose.material3.lightColorScheme

val PokedexLightColorScheme = lightColorScheme(
    primary = PokedexColors.BluePrimary,
    onPrimary = PokedexColors.White,
    primaryContainer = PokedexColors.Blue100,
    onPrimaryContainer = PokedexColors.BlueDarker,

    secondary = PokedexColors.PurplePrimary,
    onSecondary = PokedexColors.White,

    background = PokedexColors.White,
    onBackground = PokedexColors.Black,

    surface = PokedexColors.Gray50,
    onSurface = PokedexColors.Gray400,

    error = PokedexColors.RedPrimary,
    onError = PokedexColors.White
)