package com.meeweel.appbai777.mvpuser

import com.meeweel.appbai777.data.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UserView : MvpView {
    @SingleState
    fun showUser(user: GitHubUser)
}