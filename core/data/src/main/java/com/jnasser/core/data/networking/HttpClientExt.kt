package com.jnasser.core.data.networking

import com.jnasser.core.data.BuildConfig
import com.jnasser.core.domain.util.error_handler.DataError
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.CancellationException
import kotlinx.serialization.SerializationException
import com.jnasser.core.domain.util.result_handler.Result
import io.ktor.client.network.sockets.SocketTimeoutException

/**
 * Makes a GET request with optional route and query parameters,
 * wrapping the result in a [Result] with proper error mapping.
 */
suspend inline fun <reified Response : Any> HttpClient.get(
    route: String? = null,
    queryParameters: Map<String, Any?> = mapOf()
): Result<Response, DataError.Network> {
    return safeCall {
        get {
            url(constructRoute(route ?: BuildConfig.BASE_URL))
            queryParameters.forEach { (key, value) ->
                parameter(key, value)
            }
        }
    }
}

/**
 * Executes an HTTP call safely and maps known exceptions to [DataError.Network].
 * - Handles network failures, serialization issues, timeouts, etc.
 * - Returns [Result.Error] or proceeds to parse the response.
 */
suspend inline fun <reified T> safeCall(
    execute: () -> HttpResponse
): Result<T, DataError.Network> {
    val response = try {
        execute()
    } catch (e: UnresolvedAddressException) {
        e.printStackTrace()
        return Result.Error(DataError.Network.NO_INTERNET)
    } catch (e: SerializationException) {
        e.printStackTrace()
        return Result.Error(DataError.Network.SERIALIZATION)
    } catch (e: SocketTimeoutException) {
        e.printStackTrace()
        return Result.Error(DataError.Network.REQUEST_TIMEOUT)
    } catch (e: Exception) {
        if (e is CancellationException) throw e
        e.printStackTrace()
        return Result.Error(DataError.Network.UNKNOWN)
    }

    return responseToResult(response)
}

/**
 * Converts an [HttpResponse] to a [Result].
 * - Success if status code is 2xx
 * - Maps specific status codes (404, 429, 5xx) to error types
 */
suspend inline fun <reified T> responseToResult(
    response: HttpResponse
): Result<T, DataError.Network> {
    return when (response.status.value) {
        in 200..299 -> Result.Success(response.body<T>())
        404 -> Result.Error(DataError.Network.NOT_FOUND)
        429 -> Result.Error(DataError.Network.TOO_MANY_REQUEST)
        in 500..599 -> Result.Error(DataError.Network.SERVER_ERROR)
        else -> Result.Error(DataError.Network.UNKNOWN)
    }
}

/**
 * Constructs a complete URL based on the given [route].
 * If the route already contains the base URL, it's returned as-is.
 * If it starts with "/", it's appended to the base.
 * Otherwise, a "/" is added between the base and the route.
 */
fun constructRoute(route: String): String {
    return when {
        route.contains(BuildConfig.BASE_URL) -> route
        route.startsWith("/") -> BuildConfig.BASE_URL + route
        else -> BuildConfig.BASE_URL + "/$route"
    }
}
