package com.digitalcrafts.gitClub.data.internal.data.cache

import android.content.Context
import androidx.room.Room
import com.digitalcrafts.gitClub.data.internal.data.cache.definitons.GitClubDatabase


internal object CacheClient {

    private const val ROOM_DB_NAME: String = "gitClubDb"

    private var mDb: GitClubDatabase? = null

    internal val dataBase: GitClubDatabase
        get() = mDb ?: throw IllegalStateException("Database not initialized.")


    internal fun initialize(context: Context) {
        mDb = Room
            .databaseBuilder(context, GitClubDatabase::class.java, ROOM_DB_NAME)
            .build()
    }

    internal fun getDatabase(context: Context): GitClubDatabase {
        return Room
            .databaseBuilder(context, GitClubDatabase::class.java, ROOM_DB_NAME)
            .build()
    }
}