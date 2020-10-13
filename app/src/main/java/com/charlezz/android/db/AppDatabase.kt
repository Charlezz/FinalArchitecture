package com.charlezz.android.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.charlezz.android.db.entity.Category
import com.charlezz.android.db.entity.Post
import com.charlezz.android.db.entity.PostConverter
import com.charlezz.android.db.entity.User

@TypeConverters(PostConverter::class)
@Database(entities = [Post::class, User::class, Category::class], version = 6, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
    abstract fun userDao(): UserDao
    abstract fun categoryDao(): CategoryDao
}