package com.meeweel.appbai777.mvpuser

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.meeweel.appbai777.App
import com.meeweel.appbai777.R
import com.meeweel.appbai777.data.GitHubUser
import com.meeweel.appbai777.databinding.ViewUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(R.layout.view_user), UserView {

    private lateinit var viewBinding: ViewUserBinding

    private val userName: String by lazy {
        arguments?.getString(ARG_USER_NAME).orEmpty()
    }

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(userName).apply {
            App.instance.applicationComponent.provideApplicationComponent().build().inject(this)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = ViewUserBinding.bind(view)
        viewBinding.userLogin.text = userName
    }

    override fun showUser(user: GitHubUser) {
        viewBinding.userLogin.text = user.name
        Glide.with(viewBinding.userAvatar.context)
            .load(user.avatarUrl)
            .into(viewBinding.userAvatar)
    }

    companion object {
        private const val ARG_USER_NAME = "arg_user_name"

        fun newInstance(userName: String): Fragment =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_NAME, userName)
                }
            }
    }
}