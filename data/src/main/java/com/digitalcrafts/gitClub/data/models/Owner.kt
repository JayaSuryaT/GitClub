package com.digitalcrafts.gitClub.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Owner(
    val id: Int,
    val login: String,
    val url: String,
    @SerialName(AVATAR_URL) val avatarUrl: String,
    @SerialName(HTML_URL) val htmlUrl: String,
) {

    private companion object {

        private const val AVATAR_URL: String = "avatar_url"
        private const val HTML_URL: String = "html_url"
    }
}