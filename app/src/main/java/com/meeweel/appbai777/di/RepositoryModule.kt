package com.meeweel.appbai777.di

import com.meeweel.appbai777.data.GitHubUserRepository
import com.meeweel.appbai777.data.GitHubUserRepositoryImpl
import com.meeweel.appbai777.data.retrofit.GitHubApi
import com.meeweel.appbai777.data.room.DBStorage
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RepositoryModule {
    @Provides
    fun provideRepository(api: GitHubApi, dbStorage: DBStorage): GitHubUserRepository{
        return GitHubUserRepositoryImpl(api, dbStorage)
    }
}