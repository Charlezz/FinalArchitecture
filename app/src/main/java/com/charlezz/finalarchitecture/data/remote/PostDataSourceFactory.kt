package com.charlezz.finalarchitecture.data.remote

import android.arch.paging.DataSource


class PostDataSourceFactory(val apiHelper: ApiHelper) : DataSource.Factory<Long,Post>(){
    override fun create(): DataSource<Long, Post> = PostDataSource(apiHelper)
}