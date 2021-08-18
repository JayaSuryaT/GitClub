package com.digitalcrafts.gitClub.data.dataSources.impl

import com.digitalcrafts.gitClub.data.dataSources.definitons.DataSourceRepositories
import com.digitalcrafts.gitClub.data.dataSources.models.Repository
import com.digitalcrafts.gitClub.data.internal.data.cache.definitons.RepositoryDao
import com.digitalcrafts.gitClub.data.internal.data.cache.entities.RepositoryEntity
import com.digitalcrafts.gitClub.data.internal.data.network.definitons.NetworkClient
import com.digitalcrafts.gitClub.data.internal.data.network.dtos.RepositoryDto
import com.digitalcrafts.gitClub.data.internal.mappers.definitions.DtoToEntityMapper
import com.digitalcrafts.gitClub.data.internal.mappers.definitions.EntityToDomainMapper
import com.digitalcrafts.gitClub.data.internal.mappers.impl.RepositoryDtoToEntityMapper
import com.digitalcrafts.gitClub.data.internal.mappers.impl.RepositoryEntityToDomainMapper
import com.digitalcrafts.gitClub.data.internal.utils.wrapAsResult
import com.digitalcrafts.gitClub.data.models.KResult
import javax.inject.Inject

public class RepoRepositories @Inject internal constructor(
    private val networkClient: NetworkClient,
    private val cacheClient: RepositoryDao,
) : DataSourceRepositories {

    private val repoDomainMapper: EntityToDomainMapper<RepositoryEntity, Repository> by lazy {
        RepositoryEntityToDomainMapper()
    }

    private val repoDtoEntityMapper: DtoToEntityMapper<RepositoryDto, RepositoryEntity> by lazy {
        RepositoryDtoToEntityMapper()
    }

    override suspend fun getRepositoriesFor(searchKey: String):
            KResult<List<Repository>> = wrapAsResult {

        val cachedResults = getMappedDomainRepositoriesFromCache(searchKey)
        if (!cachedResults.isNullOrEmpty()) return@wrapAsResult cachedResults

        val networkResponse = networkClient.searchForRepositories(searchKey).items
        if (!networkResponse.isNullOrEmpty()) {
            val mapped = networkResponse.map(repoDtoEntityMapper::map)
            cacheClient.saveRepositories(mapped)
        }

        getMappedDomainRepositoriesFromCache(searchKey)
    }

    override suspend fun getAllCachedRepositories(): KResult<List<Repository>> = wrapAsResult {
        cacheClient.getAllRepos()
            .map(repoDomainMapper::map)
    }

    private suspend fun getMappedDomainRepositoriesFromCache(searchKey: String): List<Repository> {
        return cacheClient
            .getRepos("%$searchKey%")
            .map(repoDomainMapper::map)
    }
}