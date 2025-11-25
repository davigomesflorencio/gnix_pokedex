package  core.network

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


internal fun ktorClient(): HttpClient = HttpClient {
    install(plugin = ContentNegotiation) {
        json(
            json = Json {
                ignoreUnknownKeys = true
                isLenient = true
            },
            contentType = ContentType.Application.Json
        )
    }
    install(plugin = HttpTimeout) {
        requestTimeoutMillis = 15_000
        connectTimeoutMillis = 10_000
        socketTimeoutMillis = 15_000
    }
    install(plugin = Logging) {
        logger = Logger.SIMPLE
        level = LogLevel.ALL
    }
}