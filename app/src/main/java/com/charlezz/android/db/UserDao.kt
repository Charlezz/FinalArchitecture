package com.charlezz.android.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.charlezz.android.db.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user where id==:id")
    suspend fun getUser(id: Int):User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(posts: List<User>)

    @Query("DELETE FROM user")
    fun deleteAll()
}