package com.digitalcrafts.gitClub.data.dataSources.models

import com.digitalcrafts.gitClub.data.internal.DomainModel


public data class Repository(
    val id: Int,
    val name: String,
    val description: String?,
    val language: String?,
    val url: String,
    val fork: Boolean,
    val archived: Boolean,
    val owner: Owner,
    val htmlUrl: String,
    val fullName: String,
    val pushedAt: String,
    val updatedAt: String,
    val createdAt: String,
    val stargazersCount: Int,
    val watchersCount: Int,
    val forksCount: Int,
) : DomainModel