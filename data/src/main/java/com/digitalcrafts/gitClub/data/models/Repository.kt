package com.digitalcrafts.gitClub.data.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Entity(tableName = Repository.REPO_TABLE_NAME)
@Serializable
public data class Repository(

    @PrimaryKey val id: Int,
    val name: String,
    val description: String?,
    val language: String?,
    val url: String,
    val fork: Boolean,
    val archived: Boolean,
    @SerialName(OWNER) @Embedded(prefix = "_owner") val owner: Owner,
    @SerialName(FULL_NAME) @ColumnInfo(name = FULL_NAME) val fullName: String,
    @SerialName(PUSHED_AT) @ColumnInfo(name = PUSHED_AT) val pushedAt: String,
    @SerialName(UPDATED_AT) @ColumnInfo(name = UPDATED_AT) val updatedAt: String,
    @SerialName(CREATED_AT) @ColumnInfo(name = CREATED_AT) val createdAt: String,
    @SerialName(STARGAZERS_COUNT) @ColumnInfo(name = STARGAZERS_COUNT) val stargazersCount: Int,
    @SerialName(WATCHERS_COUNT) @ColumnInfo(name = WATCHERS_COUNT) val watchersCount: Int,
    @SerialName(FORKS_COUNT) @ColumnInfo(name = FORKS_COUNT) val forksCount: Int,
) {

    internal companion object {

        const val REPO_TABLE_NAME: String = "repository"

        private const val OWNER: String = "owner"
        private const val FULL_NAME: String = "full_name"
        private const val STARGAZERS_COUNT: String = "stargazers_count"
        private const val WATCHERS_COUNT: String = "watchers_count"
        private const val FORKS_COUNT: String = "forks_count"
        private const val CREATED_AT: String = "created_at"
        private const val UPDATED_AT: String = "updated_at"
        private const val PUSHED_AT: String = "pushed_at"
    }
}