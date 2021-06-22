package com.digitalcrafts.gitClub.data.dataSources.definitions

import com.digitalcrafts.gitClub.data.models.KResult
import com.digitalcrafts.gitClub.data.models.Repository

public interface DataSourceRepositories : DataSourceBase {

    public suspend fun getRepositoriesFor(searchKey: String): KResult<List<Repository>>

    public suspend fun getAllCachedRepositories(): KResult<List<Repository>>
}