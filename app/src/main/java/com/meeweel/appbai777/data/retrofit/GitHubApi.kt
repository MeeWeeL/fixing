package com.meeweel.appbai777.data.retrofit

import com.meeweel.appbai777.data.GitHubUser
import com.meeweel.appbai777.data.room.userrepo.GitHubUserEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {
    @GET("/users")
    fun fetchUsers(): Single<List<GitHubUser>>

    @GET("/users/{name}")
    fun fetchUserByName(@Path("name") name: String): Single<GitHubUser>

    @GET("/users/{login}/repos")
    fun fetchUserRepositories(@Path("login") login: String): Single<List<GitHubUserEntity>>
}