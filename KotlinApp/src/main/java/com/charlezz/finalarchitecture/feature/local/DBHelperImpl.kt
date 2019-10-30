package com.charlezz.finalarchitecture.feature.local

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class DBHelperImpl (private val personDao: PersonDao) : DBHelper {
    override fun getPersons(): LiveData<PagedList<Person>> = LivePagedListBuilder(
            personDao.getPersonSource(),
            PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPageSize(20)
                    .build()).build()


}