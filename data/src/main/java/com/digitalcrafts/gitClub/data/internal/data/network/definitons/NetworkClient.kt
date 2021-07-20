package com.digitalcrafts.gitClub.data.internal.data.network.definitons

import com.digitalcrafts.gitClub.data.internal.data.network.dtos.RemoteRepositoryResponse

internal interface NetworkClient {

    suspend fun searchForRepositories(searchKey: String): RemoteRepositoryResponse
}