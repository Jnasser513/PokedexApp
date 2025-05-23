package com.jnasser.core.data.di

import com.jnasser.core.data.coroutines.DispatcherProviderImpl
import com.jnasser.core.data.networking.HttpClientFactory
import com.jnasser.core.data.repositories.OfflineFirstPokemonRepository
import com.jnasser.core.domain.coroutines.DispatcherProvider
import com.jnasser.core.domain.pokemon.repositories.PokemonRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }

    singleOf(::DispatcherProviderImpl).bind<DispatcherProvider>()

    singleOf(::OfflineFirstPokemonRepository).bind<PokemonRepository>()
}