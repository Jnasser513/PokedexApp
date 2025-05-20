package com.jnasser.core.presentation.designsystem.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.jnasser.core.presentation.designsystem.theme.PokedexAppTheme

data class PokedexChipConfig(
    val text: String,
    val iconDrawable: Int? = null,
    val onClick: () -> Unit,
)

@Composable
fun PokedexChip(
    modifier: Modifier = Modifier,
    config: PokedexChipConfig,
) {
    AssistChip(
        onClick = config.onClick,
        label = {
            Text(
                text = config.text,
                style = MaterialTheme.typography.labelSmall
            )
        },
        leadingIcon = {
            config.iconDrawable?.let { icon ->
                Icon(
                    modifier = Modifier.size(AssistChipDefaults.IconSize),
                    imageVector = ImageVector.vectorResource(icon),
                    contentDescription = null
                )
            }
        }
    )
}

@Preview
@Composable
private fun PokedexChipPreview() {
    PokedexAppTheme {
        PokedexChip(
            config = PokedexChipConfig(
                text = "Fuego",
                iconDrawable = null,
            ){}
        )
    }
}