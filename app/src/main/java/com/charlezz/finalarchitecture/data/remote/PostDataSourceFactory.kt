package com.charlezz.finalarchitecture.data.remote

import android.arch.paging.DataSource


class PostDataSourceFactory(apiHelper: ApiHelper,postId:Long) : DataSource.Factory<Long,Post>(){
    override fun create(): DataSource<Long, Post> {
    }

}