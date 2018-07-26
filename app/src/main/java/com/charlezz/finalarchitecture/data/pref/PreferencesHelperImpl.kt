package com.charlezz.finalarchitecture.data.pref

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class PreferencesHelperImpl @Inject constructor(context: Context, @Named("my_pref") prefName: String) : PreferencesHelper {

    val KEY_DATA = "data"

    val preference: SharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE) as SharedPreferences
    val editor: SharedPreferences.Editor = preference.edit()


    private val data = MutableLiveData<String>()

    override fun getData(): String = preference.getString(KEY_DATA,"")

    override fun setData(data: String): Boolean = editor.putString(KEY_DATA, data).commit()

}