package com.digitalcrafts.gitClub.data.internal.network

import com.digitalcrafts.gitClub.data.internal.models.RemoteRepositoryResponse
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*

internal class NetworkClient {

    private val client: HttpClient by lazy {

        HttpClient(CIO) {

            install(Logging) {
                level = LogLevel.ALL
            }

            install(HttpTimeout) {
                requestTimeoutMillis = 10 * 1000
                connectTimeoutMillis = 5 * 1000
                socketTimeoutMillis = 30 * 1000
            }

            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    encodeDefaults = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    suspend fun searchForRepositories(repositoryName: String): RemoteRepositoryResponse {
        val route = Router.searchRepositories(repositoryName)
        return client.get(block = route)
    }
}