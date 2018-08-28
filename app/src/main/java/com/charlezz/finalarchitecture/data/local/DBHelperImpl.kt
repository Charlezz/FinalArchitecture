package com.charlezz.finalarchitecture.data.local

import android.arch.paging.DataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DBHelperImpl @Inject constructor(private val appDatabase: AppDatabase): DBHelper {
    override fun getAllPersonsSource(): DataSource.Factory<Int, Person> {
        return appDatabase.dao().getAllPersonsSource()
    }
}