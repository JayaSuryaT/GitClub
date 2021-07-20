package com.digitalcrafts.gitClub.data.internal.data.cache.entities

import com.digitalcrafts.gitClub.data.internal.EntityModel


internal data class OwnerEntity(
    val id: Int,
    val login: String,
    val url: String,
    val avatarUrl: String,
    val htmlUrl: String,
) : EntityModel