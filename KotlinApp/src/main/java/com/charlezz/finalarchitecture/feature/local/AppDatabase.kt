package com.charlezz.finalarchitecture.feature.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [(Person::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): PersonDao
}