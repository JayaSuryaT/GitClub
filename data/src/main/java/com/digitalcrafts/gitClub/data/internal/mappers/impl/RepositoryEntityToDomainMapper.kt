package com.digitalcrafts.gitClub.data.internal.mappers.impl

import com.digitalcrafts.gitClub.data.dataSources.models.Owner
import com.digitalcrafts.gitClub.data.dataSources.models.Repository
import com.digitalcrafts.gitClub.data.internal.data.cache.entities.OwnerEntity
import com.digitalcrafts.gitClub.data.internal.data.cache.entities.RepositoryEntity
import com.digitalcrafts.gitClub.data.internal.mappers.definitions.EntityToDomainMapper

internal class RepositoryEntityToDomainMapper : EntityToDomainMapper<RepositoryEntity, Repository> {

    private val ownerMapper by lazy { OwnerEntityToDomainMapper() }

    override fun map(model: RepositoryEntity): Repository {
        model.apply {
            return Repository(
                id = id,
                name = name,
                description = description,
                language = language,
                url = url,
                fork = fork,
                archived = archived,
                owner = ownerMapper.map(owner),
                htmlUrl = htmlUrl,
                fullName = fullName,
                pushedAt = pushedAt,
                updatedAt = updatedAt,
                createdAt = createdAt,
                stargazersCount = stargazersCount,
                watchersCount = watchersCount,
                forksCount = forksCount,
            )
        }
    }

    private class OwnerEntityToDomainMapper : EntityToDomainMapper<OwnerEntity, Owner> {
        override fun map(model: OwnerEntity): Owner {
            model.apply {
                return Owner(
                    id = id,
                    login = login,
                    url = url,
                    avatarUrl = avatarUrl,
                    htmlUrl = htmlUrl,
                )
            }
        }
    }
}