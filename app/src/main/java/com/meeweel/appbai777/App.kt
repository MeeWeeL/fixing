package com.meeweel.appbai777

import android.app.Application
import android.content.Context
import com.meeweel.appbai777.di.ApplicationComponent
import com.meeweel.appbai777.di.DaggerApplicationComponent

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        applicationComponent = DaggerApplicationComponent.builder()
            .setContext(this)
            .build()
    }

    companion object  {
        lateinit var instance: App
    }
    fun getContext(): Context = applicationContext

}