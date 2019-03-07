package com.charlezz.finalarchitecture.feature.pref

interface PreferencesHelper {
    fun getData(): String
    fun setData(data: String): Boolean
}