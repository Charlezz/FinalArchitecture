package com.charlezz.finalarchitecture.data.photo

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.database.Cursor

class PhotoHelperImpl: PhotoHelper{
    override fun fetchPhotos(cursor:Cursor): LiveData<PagedList<Photo>> {
        return LivePagedListBuilder<Int, Photo>(
                PhotoDataSourceFactory(cursor),
                PagedList.Config.Builder()
                        .setEnablePlaceholders(true)
                        .setPageSize(30)
                        .build()
        ).build()
    }
}