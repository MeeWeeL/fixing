package com.meeweel.appbai777.mvpusers

import com.meeweel.appbai777.data.GitHubUserRepository
import com.meeweel.appbai777.mvpuser.UserScreen
import com.meeweel.appbai777.navigation.CustomRouter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class UsersPresenter(
    //private val subject: @NonNull BehaviorSubject<String> = BehaviorSubject.create()
) : MvpPresenter<UsersView>() {

    @Inject lateinit var userRepository: GitHubUserRepository
    @Inject lateinit var router: CustomRouter

    override fun onFirstViewAttach() {
        updateContent()
    }

    fun goToNextScreen(name: String) {
//        router.openDeepLink(name)
        router.navigateTo(UserScreen(name))
    }

    private fun updateContent() {
        userRepository
            .getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showUsers(it)
            },{

            })
    }
}