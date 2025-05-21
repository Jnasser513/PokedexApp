package com.jnasser.pokemon.presentation.pokemon_detail.composables

import android.graphics.drawable.VectorDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.jnasser.core.presentation.designsystem.theme.PokedexAppTheme
import com.jnasser.core.presentation.designsystem.theme.PokedexColors
import com.jnasser.core.presentation.designsystem.theme.PokedexIcons
import com.jnasser.pokemon.presentation.R
import com.jnasser.pokemon.presentation.pokemon_detail.model.MeasuresContainerDataUi

@Composable
fun MeasuresContainer(
    modifier: Modifier = Modifier,
    measuresContainerDataUi: MeasuresContainerDataUi
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(10.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        MeasureData(
            modifier = modifier.weight(1f),
            icon = PokedexIcons.Scale,
            value = stringResource(R.string.weight_value, measuresContainerDataUi.weight),
            text = stringResource(R.string.weight)
        )
        VerticalDivider(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .padding(start = 15.dp)
                .height(40.dp),
            thickness = 1.dp,
            color = PokedexColors.Gray100
        )
        MeasureData(
            modifier = modifier.weight(1f),
            icon = PokedexIcons.Ruler,
            value = stringResource(R.string.height_value, measuresContainerDataUi.height),
            text = stringResource(R.string.height)
        )
    }
}

@Composable
fun MeasureData(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    value: String,
    text: String
) {
    Row(
        modifier = modifier.padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Icon(
            modifier = Modifier.padding(horizontal = 20.dp),
            imageVector = icon,
            tint = PokedexColors.Blue200,
            contentDescription = null
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                color = PokedexColors.BlueDark
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.labelSmall,
                color = PokedexColors.Blue200
            )
        }
    }
}

@Preview
@Composable
private fun MeasuresContainerPreview() {
    PokedexAppTheme {
        MeasuresContainer(
            measuresContainerDataUi = MeasuresContainerDataUi(
                height = "1,7",
                weight = "90,5"
            )
        )
    }
}