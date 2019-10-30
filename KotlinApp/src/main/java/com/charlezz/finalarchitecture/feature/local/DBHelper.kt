package com.charlezz.finalarchitecture.feature.local

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

interface DBHelper{
    fun getPersons():LiveData<PagedList<Person>>
}