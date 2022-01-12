package com.meeweel.appbai777.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "GitHubUserTable")
data class GitHubUser(

    @PrimaryKey()
    @SerializedName("id")
    val id: String,

    @ColumnInfo
    @SerializedName("login")
    val login: String? = null,

    @ColumnInfo
    @SerializedName("avatar_url")
    val avatarUrl: String? = null,

    @ColumnInfo
    @SerializedName("type")
    val type: String = "",

    @ColumnInfo
    @SerializedName("name")
    val name: String = ""
)