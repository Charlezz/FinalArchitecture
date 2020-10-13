package com.charlezz.android.db

import androidx.paging.PagingSource
import androidx.room.*
import com.charlezz.android.db.entity.Post

@Dao
interface PostDao{
    @Query("SELECT * FROM post ORDER BY date DESC")
    fun getPosts(): PagingSource<Int, Post>

    @Query("SELECT * FROM post ORDER BY date DESC LIMIT 1")
    fun getLatestPost(): Post?

    @Query("SELECT * FROM post ORDER BY date ASC LIMIT 1")
    fun getEarliestPost(): Post?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(posts : List<Post>)

    @Query("DELETE FROM post")
    fun deleteAll()


}