package com.digitalcrafts.gitClub.data.internal.mappers.impl

import com.digitalcrafts.gitClub.data.internal.data.cache.entities.OwnerEntity
import com.digitalcrafts.gitClub.data.internal.data.cache.entities.RepositoryEntity
import com.digitalcrafts.gitClub.data.internal.data.network.dtos.OwnerDto
import com.digitalcrafts.gitClub.data.internal.data.network.dtos.RepositoryDto
import com.digitalcrafts.gitClub.data.internal.mappers.definitions.DtoToEntityMapper

internal class RepositoryDtoToEntityMapper : DtoToEntityMapper<RepositoryDto, RepositoryEntity> {

    private val ownerMapper by lazy { OwnerDtoToEntityMapper() }

    override fun map(model: RepositoryDto): RepositoryEntity {
        model.apply {
            return RepositoryEntity(
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

    private class OwnerDtoToEntityMapper : DtoToEntityMapper<OwnerDto, OwnerEntity> {
        override fun map(model: OwnerDto): OwnerEntity {
            model.apply {
                return OwnerEntity(
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