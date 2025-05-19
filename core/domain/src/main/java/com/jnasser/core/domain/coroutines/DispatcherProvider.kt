package com.jnasser.core.domain.coroutines

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Provides coroutine dispatchers for different threading contexts.
 * Allows abstraction of dispatcher usage for easier testing and flexibility.
 */
interface DispatcherProvider {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
}