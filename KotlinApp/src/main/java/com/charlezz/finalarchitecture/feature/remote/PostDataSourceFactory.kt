package com.charlezz.finalarchitecture.feature.remote

import androidx.paging.DataSource


class PostDataSourceFactory(val apiHelper: ApiHelper) : DataSource.Factory<Long, Post>(){
    override fun create(): DataSource<Long, Post> = PostDataSource(apiHelper)
}