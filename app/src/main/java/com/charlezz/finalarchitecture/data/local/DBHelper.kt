package com.charlezz.finalarchitecture.data.local

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList

interface DBHelper{
    fun getPersons():LiveData<PagedList<Person>>
}