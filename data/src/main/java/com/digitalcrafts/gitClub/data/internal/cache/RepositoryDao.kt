package com.digitalcrafts.gitClub.data.internal.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.digitalcrafts.gitClub.data.models.Repository

@Dao
internal interface RepositoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRepositories(repos: List<Repository>)

    @Query("SELECT * FROM repository WHERE name LIKE :searchKey OR description LIKE :searchKey ORDER BY watchers_count DESC")
    suspend fun getRepos(searchKey: String): List<Repository>

    @Query("SELECT * FROM repository ORDER BY watchers_count DESC")
    suspend fun getAllRepos(): List<Repository>
}