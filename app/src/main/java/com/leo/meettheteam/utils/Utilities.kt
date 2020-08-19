package com.leo.meettheteam.utils

import android.content.Context
import java.io.IOException

object Utilities {

    fun getJsonFromAssets(context: Context, fileName: String): String? {
        val json: String
        try {
            json = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }

        return json
    }

}