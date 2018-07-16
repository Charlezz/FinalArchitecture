package com.charlezz.finalarchitecture.data

import android.arch.paging.DataSource
import com.charlezz.finalarchitecture.data.local.DBHelper
import com.charlezz.finalarchitecture.data.local.entity.Person
import com.charlezz.finalarchitecture.data.pref.PreferencesHelper
import com.charlezz.finalarchitecture.data.remote.ApiHelper

interface DataManager : ApiHelper, DBHelper, PreferencesHelper {
    override fun getAllPersons():DataSource.Factory<Int, Person>
}