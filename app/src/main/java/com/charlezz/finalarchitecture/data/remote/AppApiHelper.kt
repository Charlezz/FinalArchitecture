package com.charlezz.finalarchitecture.data.remote

import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppApiHelper
@Inject constructor(val apiHelper: ApiHelper) :ApiHelper{
    override fun getPosts(): Call<List<Post>>  = apiHelper.getPosts()

    override fun getPosts(page: Int) = apiHelper.getPosts(page)

    override fun getPost(id: Long): Call<Post> = apiHelper.getPost(id)

    override fun getPosts(page:Int, limit:Int)= apiHelper.getPosts(page, limit)
}