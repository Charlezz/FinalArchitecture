package com.charlezz.android.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.charlezz.android.db.entity.Category

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category where id==:id")
    fun getCategory(id: Int): Category?

    @Query("DELETE FROM category")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(categories: List<Category>)

}