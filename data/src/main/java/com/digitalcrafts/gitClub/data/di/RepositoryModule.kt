package com.digitalcrafts.gitClub.data.di

import com.digitalcrafts.gitClub.data.dataSources.definitons.DataSourceRepositories
import com.digitalcrafts.gitClub.data.dataSources.impl.RepoRepositories
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class RepositoryModule {

    @Binds
    internal abstract fun getRepoRepository(impl: RepoRepositories): DataSourceRepositories
}