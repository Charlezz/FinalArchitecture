package com.charlezz.android

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PrefManager @Inject constructor(private val sharedPreferences: SharedPreferences) {

    private val editor = sharedPreferences.edit()

    fun updateLatestPostDate(latestPostDate: String) {
        editor.putString(Keys.LATEST_POST_DATE, latestPostDate)
    }

    fun deleteLatestPostDate() {
        editor.putString(Keys.LATEST_POST_DATE, null)
    }

    fun getLatestPostDate(fallback: String): String {
        return sharedPreferences.getString(Keys.LATEST_POST_DATE, fallback) ?: return fallback

    }

    object Keys {
        const val LATEST_POST_DATE = "LATEST_POST_DATE"
    }
}