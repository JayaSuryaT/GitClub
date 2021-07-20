package com.digitalcrafts.gitClub.data.internal.data.cache.definitons

import androidx.room.Database
import androidx.room.RoomDatabase
import com.digitalcrafts.gitClub.data.internal.data.cache.entities.RepositoryEntity

@Database(entities = [RepositoryEntity::class], version = 1, exportSchema = true)
internal abstract class GitClubDatabase : RoomDatabase() {

    abstract fun repositoryDao(): RepositoryDao
}