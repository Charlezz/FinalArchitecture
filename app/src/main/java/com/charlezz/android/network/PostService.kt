package com.charlezz.android.network

import com.charlezz.android.db.entity.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostService {

    @GET("?rest_route=/wp/v2/posts")
    suspend fun getPosts(): List<Post>

    @GET("?rest_route=/wp/v2/posts")
    fun getPostsByPage(@Query("page") page: Int): List<Post>

    @GET("?rest_route=/wp/v2/posts")
    suspend fun getPostsBefore(@Query("before") before: String, @Query("per_page") perPage: Int): List<Post>

    @GET("?rest_route=/wp/v2/posts")
    suspend fun getPostsAfter(@Query("after") after: String, @Query("per_page") perPage: Int): List<Post>

    @GET("?rest_route=/wp/v2/posts")
    fun getPosts(
            @Query("after") after: String?,
            @Query("before") before: String?,
            @Query("per_page") perPage: Int = 10
    ): Call<List<Post>>

}