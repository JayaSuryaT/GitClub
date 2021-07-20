package com.digitalcrafts.gitClub.data.internal.data.cache.definitons

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.digitalcrafts.gitClub.data.internal.data.cache.entities.RepositoryEntity

@Dao
internal interface RepositoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRepositories(repos: List<RepositoryEntity>)

    @Query("SELECT * FROM repository WHERE name LIKE :searchKey OR description LIKE :searchKey")
    suspend fun getRepos(searchKey: String): List<RepositoryEntity>

    @Query("SELECT * FROM repository")
    suspend fun getAllRepos(): List<RepositoryEntity>
}