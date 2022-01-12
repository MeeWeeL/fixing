package com.meeweel.appbai777.di

import android.content.Context
import com.meeweel.appbai777.MainActivity
import com.meeweel.appbai777.mvpuser.UserPresenter
import com.meeweel.appbai777.mvpusers.UsersPresenter
import com.meeweel.appbai777.di.ApplicationComponent
import com.meeweel.appbai777.mvpuser.di.GitHubUserComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        RoomModule::class
    ]
)
interface ApplicationComponent {

    fun provideApplicationComponent(): GitHubUserComponent.Builder

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun setContext(context: Context): Builder

        fun build(): ApplicationComponent
    }



    fun inject(mainActivity: MainActivity)
    fun inject(usersPresenter: UsersPresenter)

}