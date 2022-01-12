package com.meeweel.appbai777.mvpusers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.meeweel.appbai777.App
import com.meeweel.appbai777.R
import com.meeweel.appbai777.data.GitHubUser
import com.meeweel.appbai777.data.GitHubUserRepository
import com.meeweel.appbai777.databinding.ViewUsersBinding
import com.meeweel.appbai777.navigation.CustomRouter
import com.meeweel.appbai777.recycler.UsersAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class UsersFragment : MvpAppCompatFragment(R.layout.view_users), UsersView, UsersAdapter.OnUserClickListener {


    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter().apply {
            App.instance.applicationComponent.inject(this)
        }
    }

    private val usersAdapter = UsersAdapter(this)
    private lateinit var viewBinging: ViewUsersBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinging = ViewUsersBinding.bind(view)
        viewBinging.usersRecycler.adapter = usersAdapter
    }

    override fun showUsers(users: List<GitHubUser>) {
        usersAdapter.submitList(users)
    }

    override fun onUserPicked(user: GitHubUser) {
        presenter.goToNextScreen(user.login!!)
    }


    companion object {
        fun newInstance(): Fragment = UsersFragment()
    }
}