package com.charlezz.finalarchitecture.feature.local

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query


@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    fun getPersonSource():DataSource.Factory<Int, Person>
}