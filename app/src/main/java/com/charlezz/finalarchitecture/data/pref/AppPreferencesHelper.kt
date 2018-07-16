package com.charlezz.finalarchitecture.data.pref

import android.content.Context
import android.content.SharedPreferences
import com.charlezz.finalarchitecture.di.annotation.PreferenceInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferencesHelper @Inject constructor(context: Context, @PreferenceInfo prefName: String) : PreferencesHelper {

    val KEY_CARDS_VERSION = "Cards version"

    val preference: SharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE) as SharedPreferences
    val editor: SharedPreferences.Editor = preference.edit()

//    override fun setCurrentCardsVersion(version: Int) = editor.putInt(KEY_CARDS_VERSION, version).commit()
//    override fun getCurrentCardsVersion() = preference.getInt(KEY_CARDS_VERSION, 0)
}