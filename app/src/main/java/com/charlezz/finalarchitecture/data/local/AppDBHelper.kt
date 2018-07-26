package com.charlezz.finalarchitecture.data.local

import android.arch.paging.DataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDBHelper @Inject constructor(private val appDatabase: AppDatabase): DBHelper {
    override fun getAllPersons(): DataSource.Factory<Int, Person> {
        return appDatabase.dao().getAllPersons()
    }
}