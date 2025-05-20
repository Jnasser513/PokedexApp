package com.jnasser.pokedexapp

import android.app.Application
import android.content.Context
import com.jnasser.core.data.di.coreDataModule
import com.jnasser.core.database.di.databaseModule
import com.jnasser.pokemon.presentation.di.pokemonPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class PokedexApp: Application() {

    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        startKoin {
            androidLogger()
            androidContext(this@PokedexApp)
            modules(
                coreDataModule,
                pokemonPresentationModule,
                databaseModule
            )
        }
    }
}