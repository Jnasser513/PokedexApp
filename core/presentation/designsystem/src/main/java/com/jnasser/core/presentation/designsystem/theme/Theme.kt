package com.jnasser.core.presentation.designsystem.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun PokedexAppTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = PokedexLightColorScheme
    val view = LocalView.current
    if(!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = PokedexTypography,
        content = content
    )
}