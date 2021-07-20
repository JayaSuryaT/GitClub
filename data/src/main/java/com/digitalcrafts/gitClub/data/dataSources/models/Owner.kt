package com.digitalcrafts.gitClub.data.dataSources.models

import com.digitalcrafts.gitClub.data.internal.DomainModel


public data class Owner(
    val id: Int,
    val login: String,
    val url: String,
    val avatarUrl: String,
    val htmlUrl: String,
) : DomainModel