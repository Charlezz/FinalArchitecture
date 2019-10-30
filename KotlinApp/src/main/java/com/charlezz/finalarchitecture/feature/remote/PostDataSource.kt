package com.charlezz.finalarchitecture.feature.remote

import androidx.paging.ItemKeyedDataSource

class PostDataSource(val apiHelper: ApiHelper) : ItemKeyedDataSource<Long, Post>(){
    override fun loadInitial(params: LoadInitialParams<Long>, callback: LoadInitialCallback<Post>) {
        params.requestedInitialKey?.let {initialKey->
            val call = apiHelper.getPosts(initialKey, params.requestedLoadSize)
            call.execute().body()?.let {
                callback.onResult(it)
            }
        }
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Post>) {
        params.key?.let {key->
            val call = apiHelper.getPosts(key, params.requestedLoadSize)
            call.execute().body()?.let {
                callback.onResult(it)
            }
        }
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Post>) {
    }

    override fun getKey(item: Post): Long = item.id
}