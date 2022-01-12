package com.meeweel.appbai777.mvpusers

import com.meeweel.appbai777.data.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UsersView : MvpView {
    @SingleState
    fun showUsers(users: List<GitHubUser>)
}