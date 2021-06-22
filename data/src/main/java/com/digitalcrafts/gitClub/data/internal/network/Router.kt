package com.digitalcrafts.gitClub.data.internal.network

import io.ktor.client.request.*
import io.ktor.http.*


internal object Router {

    private fun base(): String = "https://api.github.com/"

    fun searchRepositories(name: String): HttpRequestBuilder.() -> Unit = {
        url.takeFrom(base() + "search/repositories")
        parameter("q", name)
    }
}