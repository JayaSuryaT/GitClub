package com.digitalcrafts.gitClub.data.internal.data.network.dtos

import com.digitalcrafts.gitClub.data.internal.DtoModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class RemoteRepositoryResponse(
    @SerialName(TOTAL_COUNT) val totalCount: Int,
    @SerialName(INCOMPLETE_RESULTS) val incompleteResults: Boolean,
    @SerialName(ITEMS) val items: List<RepositoryDto>,
) : DtoModel {

    private companion object {

        private const val TOTAL_COUNT: String = "total_count"
        private const val INCOMPLETE_RESULTS: String = "incomplete_results"
        private const val ITEMS: String = "items"
    }
}