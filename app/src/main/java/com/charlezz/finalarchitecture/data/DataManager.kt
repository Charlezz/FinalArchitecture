package com.charlezz.finalarchitecture.data

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.charlezz.finalarchitecture.data.local.DBHelper
import com.charlezz.finalarchitecture.data.local.Person
import com.charlezz.finalarchitecture.data.pref.PreferencesHelper
import com.charlezz.finalarchitecture.data.remote.ApiHelper

interface DataManager : ApiHelper, DBHelper, PreferencesHelper{
    fun getPersons():LiveData<PagedList<Person>>
}