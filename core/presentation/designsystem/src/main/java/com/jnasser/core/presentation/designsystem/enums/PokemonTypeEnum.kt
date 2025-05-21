package com.jnasser.core.presentation.designsystem.enums

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.jnasser.core.presentation.designsystem.R
import com.jnasser.core.presentation.designsystem.theme.PokedexColors

enum class PokemonTypeEnum(
    @StringRes val label: Int,
    val color: Color,
    @DrawableRes val icon: Int
) {
    NORMAL(R.string.type_normal, PokedexColors.TypeNormal, R.drawable.ic_pokeball),
    FIGHTING(R.string.type_fighting, PokedexColors.TypeFighting, R.drawable.ic_pokeball),
    FLYING(R.string.type_flying, PokedexColors.TypeFlying, R.drawable.ic_pokeball),
    POISON(R.string.type_poison, PokedexColors.TypePoison, R.drawable.ic_pokeball),
    GROUND(R.string.type_ground, PokedexColors.TypeGround, R.drawable.ic_pokeball),
    ROCK(R.string.type_rock, PokedexColors.TypeRock, R.drawable.ic_pokeball),
    BUG(R.string.type_bug, PokedexColors.TypeBug, R.drawable.ic_pokeball),
    GHOST(R.string.type_ghost, PokedexColors.TypeGhost, R.drawable.ic_pokeball),
    STEEL(R.string.type_steel, PokedexColors.TypeSteel, R.drawable.ic_pokeball),
    FIRE(R.string.type_fire, PokedexColors.TypeFire, R.drawable.ic_pokeball),
    WATER(R.string.type_water, PokedexColors.TypeWater, R.drawable.ic_pokeball),
    GRASS(R.string.type_grass, PokedexColors.TypeGrass, R.drawable.ic_pokeball),
    ELECTRIC(R.string.type_electric, PokedexColors.TypeElectric, R.drawable.ic_pokeball),
    PSYCHIC(R.string.type_psychic, PokedexColors.TypePsychic, R.drawable.ic_pokeball),
    ICE(R.string.type_ice, PokedexColors.TypeIce, R.drawable.ic_pokeball),
    DRAGON(R.string.type_dragon, PokedexColors.TypeDragon, R.drawable.ic_pokeball),
    DARK(R.string.type_dark, PokedexColors.TypeDark, R.drawable.ic_pokeball),
    FAIRY(R.string.type_fairy, PokedexColors.TypeFairy, R.drawable.ic_pokeball),
    STELLAR(R.string.type_stellar, PokedexColors.TypeStellar, R.drawable.ic_pokeball),
    UNKNOWN(R.string.type_unknown, PokedexColors.TypeUnknown, R.drawable.ic_pokeball);

    companion object {
        fun fromName(name: String): PokemonTypeEnum {
            return entries.firstOrNull { it.name.equals(name, ignoreCase = true) } ?: UNKNOWN
        }
    }
}
