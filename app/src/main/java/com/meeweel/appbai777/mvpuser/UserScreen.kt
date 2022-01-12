package com.meeweel.appbai777.mvpuser

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class UserScreen (private val userName: String): FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        UserFragment.newInstance(userName)

}