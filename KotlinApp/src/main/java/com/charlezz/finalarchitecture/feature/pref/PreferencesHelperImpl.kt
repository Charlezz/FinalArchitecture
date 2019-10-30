package com.charlezz.finalarchitecture.feature.pref

import androidx.lifecycle.MutableLiveData
import android.content.Context
import android.content.SharedPreferences

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class PreferencesHelperImpl constructor(context: Context, prefName: String) : PreferencesHelper {

    val KEY_DATA = "data"

    val preference: SharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE) as SharedPreferences
    val editor: SharedPreferences.Editor = preference.edit()


    private val data = MutableLiveData<String>()

    override fun getData(): String = preference.getString(KEY_DATA,"")

    override fun setData(data: String): Boolean = editor.putString(KEY_DATA, data).commit()

}