package com.digitalcrafts.gitClub.data.internal.data.network.dtos

import com.digitalcrafts.gitClub.data.internal.DtoModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
internal data class RepositoryDto(
    val id: Int,
    val name: String,
    val description: String?,
    val language: String?,
    val url: String,
    val fork: Boolean,
    val archived: Boolean,
    @SerialName(OWNER) val owner: OwnerDto,
    @SerialName(HTML_URL) val htmlUrl: String,
    @SerialName(FULL_NAME) val fullName: String,
    @SerialName(PUSHED_AT) val pushedAt: String,
    @SerialName(UPDATED_AT) val updatedAt: String,
    @SerialName(CREATED_AT) val createdAt: String,
    @SerialName(STARGAZERS_COUNT) val stargazersCount: Int,
    @SerialName(WATCHERS_COUNT) val watchersCount: Int,
    @SerialName(FORKS_COUNT) val forksCount: Int,
) : DtoModel {

    private companion object {

        private const val OWNER: String = "owner"
        private const val HTML_URL: String = "html_url"
        private const val FULL_NAME: String = "full_name"
        private const val STARGAZERS_COUNT: String = "stargazers_count"
        private const val WATCHERS_COUNT: String = "watchers_count"
        private const val FORKS_COUNT: String = "forks_count"
        private const val CREATED_AT: String = "created_at"
        private const val UPDATED_AT: String = "updated_at"
        private const val PUSHED_AT: String = "pushed_at"
    }
}