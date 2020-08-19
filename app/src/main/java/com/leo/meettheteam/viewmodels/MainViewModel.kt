package com.leo.meettheteam.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.leo.meettheteam.models.User
import com.leo.meettheteam.utils.Utilities

class MainViewModel(application: Application): AndroidViewModel(application) {

    companion object {
        const val TEAM_JSON = "team.json"
    }

    private val users: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>().also {
            it.value = loadUsers()
        }
    }

    fun getUsers(): LiveData<List<User>> {
        return users
    }

    private fun loadUsers(): List<User> {
        val context = getApplication<Application>().applicationContext
        val json = Utilities.getJsonFromAssets(context, TEAM_JSON)
        val gson = Gson()
        val userType = object : TypeToken<List<User>>(){}.type

        return gson.fromJson(json, userType)
    }

}