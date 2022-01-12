package com.meeweel.appbai777.data

import io.reactivex.rxjava3.core.Single

interface GitHubUserRepository {
    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByName(user: String): Single<GitHubUser>
}