package com.meeweel.appbai777.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.meeweel.appbai777.data.GitHubUser

@Database(exportSchema = false,
    entities = [GitHubUser::class],
    version = 1)
abstract class DBStorage: RoomDatabase() {
    abstract fun getGitHubUserDao(): GitHubUserDAO
}