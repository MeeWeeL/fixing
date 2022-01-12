package com.meeweel.appbai777.mvpuser.di

import android.content.Context
import androidx.room.Room
import com.meeweel.appbai777.data.room.userrepo.DBGitHubStorage
import dagger.Module
import dagger.Provides

@Module
class GitHubUserRoomModule{

    @FragmentScope
    @Provides
    fun providesRoom(app: Context): DBGitHubStorage {
        return Room.databaseBuilder(app, DBGitHubStorage::class.java, "newgithub.db")
            .build()
    }
}