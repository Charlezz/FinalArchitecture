package com.charlezz.finalarchitecture.data

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.charlezz.finalarchitecture.data.local.DBHelper
import com.charlezz.finalarchitecture.data.local.Person
import com.charlezz.finalarchitecture.data.pref.PreferencesHelper
import com.charlezz.finalarchitecture.data.remote.ApiHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class DataManagerImpl
@Inject
constructor(private val dbHelper: DBHelper,
            private val preferencesHelper: PreferencesHelper,
            private val apiHelper: ApiHelper)
    : DataManager {
    override fun getPersons(): LiveData<PagedList<Person>> = LivePagedListBuilder(
            dbHelper.getAllPersonsSource(),
            PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPageSize(20)
                    .build()).build()

    override fun getData() = preferencesHelper.getData()

    override fun setData(data: String) = preferencesHelper.setData(data)

    override fun getPosts(start: Long, limit: Int) = apiHelper.getPosts(start, limit)

    override fun getAllPersonsSource() = dbHelper.getAllPersonsSource()


}