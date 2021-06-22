package com.digitalcrafts.gitClub.data.internal.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.digitalcrafts.gitClub.data.models.Repository

@Database(entities = [Repository::class], version = 1, exportSchema = false)
internal abstract class GitClubDatabase : RoomDatabase() {

    abstract fun repositoryDao(): RepositoryDao
}