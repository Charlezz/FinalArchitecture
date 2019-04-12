package com.charlezz.finalarchitecture.feature.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiHelper {
    @GET("/posts")
    fun getPosts(
            @Query("_start") start: Long,
            @Query("_limit") limit: Int
    ): Call<List<Post>>
}