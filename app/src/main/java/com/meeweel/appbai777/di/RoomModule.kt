package com.meeweel.appbai777.di

import android.content.Context
import androidx.room.Room
import com.meeweel.appbai777.data.room.DBStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Singleton
    @Provides
    fun providesRoomModule(app: Context): DBStorage = Room.databaseBuilder(app, DBStorage::class.java, "github.db")
        .build()
}