package com.digitalcrafts.gitClub.data.di

import android.content.Context
import com.digitalcrafts.gitClub.data.internal.data.cache.CacheClient
import com.digitalcrafts.gitClub.data.internal.data.cache.definitons.GitClubDatabase
import com.digitalcrafts.gitClub.data.internal.data.cache.definitons.RepositoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal object CacheModule {

    @Provides
    fun getDataBase(
        @ApplicationContext context: Context
    ): GitClubDatabase = CacheClient.getDatabase(context)

    @Provides
    fun getCacheClient(db: GitClubDatabase): RepositoryDao = db.repositoryDao()
}