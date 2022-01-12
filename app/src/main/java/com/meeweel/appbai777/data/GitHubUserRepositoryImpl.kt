package com.meeweel.appbai777.data

import com.meeweel.appbai777.data.retrofit.GitHubApi
import com.meeweel.appbai777.data.room.DBStorage
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GitHubUserRepositoryImpl
@Inject constructor(
    private val gitHubApi: GitHubApi,
    private val roomDb: DBStorage
) : GitHubUserRepository {

    override fun getUsers(): Single<List<GitHubUser>> {
        return roomDb.getGitHubUserDao().getUsers()
            .flatMap {
                if (it.isEmpty()){
                    gitHubApi.fetchUsers()
                        .map { resultFromServer ->
                            roomDb.getGitHubUserDao().insert(resultFromServer)
                            resultFromServer
                        }
                }else{
                    Single.fromCallable {
                        roomDb.getGitHubUserDao().getUsers()
                    }
                    Single.just(it)
                }
            }
    }

    override fun getUserByName(user: String): Single<GitHubUser> {
        return gitHubApi.fetchUserByName(user)
    }

}