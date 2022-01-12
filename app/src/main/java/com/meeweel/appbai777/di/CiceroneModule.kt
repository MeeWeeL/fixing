package com.meeweel.appbai777.di

import com.meeweel.appbai777.mvpuser.di.GitHubUserComponent
import com.meeweel.appbai777.navigation.CustomRouter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [GitHubUserComponent::class])
class CiceroneModule {
    var cicerone: Cicerone<CustomRouter> = Cicerone.create(CustomRouter())

    @Provides
    fun cicerone(): Cicerone<CustomRouter> = cicerone

    @Singleton
    @Provides
    fun navigatorHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

    @Singleton
    @Provides
    fun router(): Router = cicerone.router

}