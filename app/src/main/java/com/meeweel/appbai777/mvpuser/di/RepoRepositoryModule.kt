package com.meeweel.appbai777.mvpuser.di

import com.meeweel.appbai777.data.retrofit.GitHubApi
import com.meeweel.appbai777.data.retrofit.datauser.GitHubUserRepoRepository
import com.meeweel.appbai777.data.retrofit.datauser.GitHubUserRepoRepositoryImpl
import com.meeweel.appbai777.data.room.userrepo.DBGitHubStorage
import dagger.Module
import dagger.Provides

@Module
class RepoRepositoryModule {

    @FragmentScope
    @Provides
    fun provideRepository(api: GitHubApi, dbStorage: DBGitHubStorage): GitHubUserRepoRepository {
        return GitHubUserRepoRepositoryImpl(api, dbStorage)
    }
}