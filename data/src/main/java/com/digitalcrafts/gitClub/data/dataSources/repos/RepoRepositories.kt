package com.digitalcrafts.gitClub.data.dataSources.repos

import com.digitalcrafts.gitClub.data.dataSources.definitions.DataSourceRepositories
import com.digitalcrafts.gitClub.data.internal.cache.CacheClient
import com.digitalcrafts.gitClub.data.internal.cache.RepositoryDao
import com.digitalcrafts.gitClub.data.internal.network.NetworkClient
import com.digitalcrafts.gitClub.data.internal.utils.wrapAsResult
import com.digitalcrafts.gitClub.data.models.KResult
import com.digitalcrafts.gitClub.data.models.Repository

public class RepoRepositories : DataSourceRepositories {

    private val networkClient: NetworkClient by lazy { NetworkClient() }
    private val cacheClient: RepositoryDao by lazy { CacheClient.dataBase.repositoryDao() }

    override suspend fun getRepositoriesFor(searchKey: String):
            KResult<List<Repository>> = wrapAsResult {

        val cachedRepos = cacheClient.getRepos(searchKey)
        if (!cachedRepos.isNullOrEmpty()) return@wrapAsResult cachedRepos

        val networkResponse = networkClient.searchForRepositories(searchKey).items
        if (!networkResponse.isNullOrEmpty()) cacheClient.saveRepositories(networkResponse)
        cacheClient.getRepos(searchKey)
    }

    override suspend fun getAllCachedRepositories(): KResult<List<Repository>> = wrapAsResult {
        cacheClient.getAllRepos()
    }
}