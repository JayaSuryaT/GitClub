package com.digitalcrafts.gitClub.data.internal.models

import com.digitalcrafts.gitClub.data.models.Repository
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class RemoteRepositoryResponse(
    @SerialName("total_count") val totalCount: Int,
    @SerialName("incomplete_results") val incompleteResults: Boolean,
    @SerialName("items") val items: List<Repository>,
)