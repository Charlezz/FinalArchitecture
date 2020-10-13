package com.charlezz.android.network

import com.charlezz.android.db.entity.User
import retrofit2.http.GET

interface UserService{
    @GET("?rest_route=/wp/v2/users")
    suspend fun getUsers(): List<User>
}