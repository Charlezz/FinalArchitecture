package com.charlezz.finalarchitecture.data.pref

interface PreferencesHelper {
    fun getData(): String
    fun setData(data: String): Boolean
}