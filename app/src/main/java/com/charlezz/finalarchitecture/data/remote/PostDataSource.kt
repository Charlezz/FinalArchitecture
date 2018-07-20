package com.charlezz.finalarchitecture.data.remote

import android.arch.paging.ItemKeyedDataSource

class PostDataSource(val apiHelper: ApiHelper, postId: Long) : ItemKeyedDataSource<Long, Post>() {
    override fun loadInitial(params: LoadInitialParams<Long>, callback: LoadInitialCallback<Post>) {
        val loadsize = params.requestedLoadSize
        apiHelper.getPost()
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Post>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Post>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getKey(item: Post): Long = item.id

}