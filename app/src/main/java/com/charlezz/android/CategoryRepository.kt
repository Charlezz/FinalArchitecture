package com.charlezz.android

import androidx.room.PrimaryKey
import com.charlezz.android.db.AppDatabase
import com.charlezz.android.db.entity.Category
import javax.inject.Inject


class CategoryRepository @Inject constructor(private val db: AppDatabase) {

    private val userCache = HashMap<@PrimaryKey Int, Category>()

    suspend fun getCategory(id: Int): Category? {
        return if (userCache.containsKey(id)) {
            userCache[id]
        } else {
            db.categoryDao().getCategory(id)
        }

    }
}