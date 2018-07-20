package com.charlezz.finalarchitecture.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiHelper {
    @GET("/posts")
    fun getPosts(): Call<List<Post>>

    @GET("/posts")
    fun getPosts(@Query("_page") page: Int)

    @GET("/posts")
    fun getPosts(
            @Query("_page") page: Int,
            @Query("_limit") limit: Int
    )

    @GET("/posts/{id}")
    fun getPost(@Path("id") id: Long): Call<Post>

}