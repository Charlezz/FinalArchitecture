package com.charlezz.finalarchitecture.data.remote

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiHelperImpl
@Inject constructor(val apiHelper: ApiHelper) :ApiHelper{
    override fun getPosts(start:Long, limit:Int)= apiHelper.getPosts(start, limit)
}