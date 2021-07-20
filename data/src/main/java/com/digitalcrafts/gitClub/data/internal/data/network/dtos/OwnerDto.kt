package com.digitalcrafts.gitClub.data.internal.data.network.dtos

import com.digitalcrafts.gitClub.data.internal.DtoModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class OwnerDto(
    val id: Int,
    val login: String,
    val url: String,
    @SerialName(AVATAR_URL) val avatarUrl: String,
    @SerialName(HTML_URL) val htmlUrl: String,
) : DtoModel {

    private companion object {

        private const val AVATAR_URL: String = "avatar_url"
        private const val HTML_URL: String = "html_url"
    }
}