package com.jnasser.core.data.networking

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import timber.log.Timber

/**
 * Factory class responsible for creating a preconfigured instance of [HttpClient].
 * This client is used to perform HTTP requests across the application.
 */
class HttpClientFactory {

    /**
     * Builds an [HttpClient] with:
     * - CIO engine for network I/O
     * - JSON serialization using kotlinx.serialization
     * - Request/response logging via Timber
     * - Default content type set to application/json
     */
    fun build(): HttpClient {
        return HttpClient(CIO) {
            // Set up JSON serialization and deserialization
            install(ContentNegotiation) {
                json(
                    json = Json {
                        ignoreUnknownKeys = true // Ignores unknown JSON keys to avoid crashes
                    }
                )
            }

            // Logs HTTP requests and responses using Timber (for debugging)
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Timber.d(message)
                    }
                }
                level = LogLevel.ALL
            }

            // Sets the default Content-Type for all outgoing requests
            defaultRequest {
                contentType(ContentType.Application.Json)
            }
        }
    }
}
