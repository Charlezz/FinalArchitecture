package com.charlezz.finalarchitecture.feature.local

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList

interface DBHelper{
    fun getPersons():LiveData<PagedList<Person>>
}