package com.jnasser.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jnasser.core.database.daos.PokemonDao

@Database(
    entities = [

    ],
    version = RoomConstants.POKEMON_ROOM_DB_VERSION
)
abstract class PokemonDatabase: RoomDatabase() {
    abstract val pokemonDao: PokemonDao
}