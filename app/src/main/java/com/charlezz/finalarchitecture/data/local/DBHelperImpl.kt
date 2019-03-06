package com.charlezz.finalarchitecture.data.local

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList

class DBHelperImpl (private val personDao: PersonDao) : DBHelper {
    override fun getPersons(): LiveData<PagedList<Person>> = LivePagedListBuilder(
            personDao.getPersonSource(),
            PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPageSize(20)
                    .build()).build()


}