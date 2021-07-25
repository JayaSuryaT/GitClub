package com.digitalcrafts.gitClub.data.internal.data.network.impl

import com.digitalcrafts.gitClub.data.internal.data.network.definitons.NetworkClient
import com.digitalcrafts.gitClub.data.internal.data.network.dtos.RemoteRepositoryResponse
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import javax.inject.Inject

internal class NetworkClientImpl @Inject constructor() : NetworkClient {

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

    override suspend fun searchForRepositories(searchKey: String): RemoteRepositoryResponse {
        val route = Router.searchRepositories(searchKey)
        return client.get(block = route)
    }
}