package com.digitalcrafts.gitClub.data.internal.data.network.impl

import io.ktor.client.request.*
import io.ktor.http.*


internal object Router {

    private fun base(): String = "https://api.github.com/"

    @Suppress("SameParameterValue")
    private fun search(searchKey: String): String = "search/$searchKey"

    fun searchRepositories(name: String): HttpRequestBuilder.() -> Unit = {
        url.takeFrom(base() + search("repositories"))
        parameter("q", name)
    }
}