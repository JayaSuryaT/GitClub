package com.digitalcrafts.gitClub.data.dataSources.definitons

import com.digitalcrafts.gitClub.data.models.KResult
import com.digitalcrafts.gitClub.data.dataSources.models.Repository

public interface DataSourceRepositories {

    public suspend fun getRepositoriesFor(searchKey: String): KResult<List<Repository>>

    public suspend fun getAllCachedRepositories(): KResult<List<Repository>>
}