package com.meeweel.appbai777.mvpuser.di

import com.meeweel.appbai777.mvpuser.UserPresenter
import dagger.Subcomponent
import javax.inject.Scope

@FragmentScope
@Subcomponent(
    modules = [
        GitHubUserRoomModule::class,
        RepoRepositoryModule::class
    ]
)
interface GitHubUserComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): GitHubUserComponent
    }

    fun inject(activity: UserPresenter)
}

@Scope
annotation class FragmentScope