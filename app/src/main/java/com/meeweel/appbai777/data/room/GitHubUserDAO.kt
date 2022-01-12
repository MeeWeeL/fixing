package com.meeweel.appbai777.data.room

import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import com.meeweel.appbai777.data.GitHubUser
import io.reactivex.rxjava3.core.Single

@Dao
interface GitHubUserDAO {
    @Query("SELECT * FROM GitHubUserTable")
    fun getUsers():Single<List<GitHubUser>>

    @Query("SELECT * FROM GitHubUserTable WHERE login LIKE :login LIMIT 1")
    fun getUserByLogin(login: String): Single<GitHubUser>

    @Insert(onConflict = REPLACE)
    fun save(users: List<GitHubUser>)

    @Insert(onConflict = REPLACE)
    fun saveUser(user: GitHubUser)

    @Insert(onConflict = IGNORE)
    fun insert(Entity: List<GitHubUser>)

    @Update
    fun update(user: List<GitHubUser>)

    @Update
    fun update(user: GitHubUser)

    @Delete
    fun delete(user: GitHubUser)
}