package com.charlezz.finalarchitecture.data.local

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query


@Dao
interface DBHelper {
    @Query("SELECT * FROM person")
    fun getAllPersons():DataSource.Factory<Int, Person>
}