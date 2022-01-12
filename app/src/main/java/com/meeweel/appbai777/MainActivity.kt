package com.meeweel.appbai777

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meeweel.appbai777.databinding.ActivityMainBinding
import com.meeweel.appbai777.mvpusers.UsersScreen
import com.meeweel.appbai777.navigation.CustomNavigator
import com.meeweel.appbai777.navigation.CustomRouter
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    lateinit var router: CustomRouter

    private val navigator = CustomNavigator(this, R.id.content)

    lateinit var binding: ActivityMainBinding

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        App.instance.applicationComponent.inject(this)
        if (savedInstanceState == null) {
            router.newRootScreen(UsersScreen())
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}