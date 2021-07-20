package com.digitalcrafts.gitClub.data.internal.data.cache.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.digitalcrafts.gitClub.data.internal.EntityModel


@Entity(tableName = RepositoryEntity.REPO_TABLE_NAME)
internal data class RepositoryEntity(

    @PrimaryKey val id: Int,
    val name: String,
    val description: String?,
    val language: String?,
    val url: String,
    val fork: Boolean,
    val archived: Boolean,
    val htmlUrl: String,
    val fullName: String,
    val pushedAt: String,
    val updatedAt: String,
    val createdAt: String,
    val stargazersCount: Int,
    val watchersCount: Int,
    val forksCount: Int,
    @Embedded(prefix = "_owner") val owner: OwnerEntity,
) : EntityModel {

    internal companion object {

        internal const val REPO_TABLE_NAME: String = "repository"
    }
}