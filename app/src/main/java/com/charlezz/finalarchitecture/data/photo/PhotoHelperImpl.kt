package com.charlezz.finalarchitecture.data.photo

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.content.Context

class PhotoHelperImpl(val context: Context) : PhotoHelper{

    override fun fetchPhotos(): LiveData<PagedList<Photo>> {
        return LivePagedListBuilder<Int, Photo>(
                PhotoDataSourceFactory(context),
                PagedList.Config.Builder()
                        .setEnablePlaceholders(true)
                        .setPageSize(30)
                        .build()
        ).build()
    }

}