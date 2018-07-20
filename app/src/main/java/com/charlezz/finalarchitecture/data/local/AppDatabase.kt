package com.charlezz.finalarchitecture.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.charlezz.finalarchitecture.data.local.dao.DBHelper
import com.charlezz.finalarchitecture.data.local.entity.Person

@Database(entities = [(Person::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): DBHelper
}