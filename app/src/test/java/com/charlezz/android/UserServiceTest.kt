package com.charlezz.android

import com.charlezz.android.db.entity.Post
import com.charlezz.android.db.entity.PostDeserializer
import com.charlezz.android.network.UserService
import com.google.gson.GsonBuilder
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class UserServiceTest {

    lateinit var retrofit: Retrofit

    @Before
    fun setup() {
        val gson = GsonBuilder()
        gson.registerTypeAdapter(Post::class.java, PostDeserializer())

        retrofit = Retrofit.Builder()
                .baseUrl("https://charlezz.com")
                .addConverterFactory(GsonConverterFactory.create(gson.create()))
                .build()
    }

    @Test
    fun getPosts() {
        runBlocking {
            println(retrofit.create(UserService::class.java).getUsers())
        }

    }


}