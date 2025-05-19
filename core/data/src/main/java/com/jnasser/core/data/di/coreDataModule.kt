package com.jnasser.core.data.di

import com.jnasser.core.data.coroutines.DispatcherProviderImpl
import com.jnasser.core.domain.coroutines.DispatcherProvider
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    singleOf(::DispatcherProviderImpl).bind<DispatcherProvider>()
}