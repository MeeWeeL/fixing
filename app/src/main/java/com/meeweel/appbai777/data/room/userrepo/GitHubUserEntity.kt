package com.meeweel.appbai777.data.room.userrepo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "GitHubUserEntity")
data class GitHubUserEntity(

    @PrimaryKey(autoGenerate = true)
    @SerializedName("localId")
    val localId: Int,

    @ColumnInfo
    @SerializedName("login")
    val login: String,

    @ColumnInfo
    @SerializedName("id")
    val id: Int,

    @ColumnInfo
    @SerializedName("name")
    val name: String,

    @ColumnInfo
    @SerializedName("html_url")
    val html_url: String
)