package com.leo.meettheteam.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(@SerializedName("id") val id : String,
                @SerializedName("name") val name : String,
                @SerializedName("position") val position : String,
                @SerializedName("profile_image") val profileImage : String,
                @SerializedName("personality") val personality : String,
                @SerializedName("interests") val interests : String,
                @SerializedName("dating_preferences") val datingPreferences : String): Parcelable