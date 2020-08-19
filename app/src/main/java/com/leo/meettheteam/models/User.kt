package com.leo.meettheteam.models

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("id") val id : String,
                @SerializedName("name") val name : String,
                @SerializedName("position") val position : String,
                @SerializedName("profile_image") val profile_image : String,
                @SerializedName("personality") val personality : String,
                @SerializedName("interests") val interests : String,
                @SerializedName("dating_preferences") val dating_preferences : String)