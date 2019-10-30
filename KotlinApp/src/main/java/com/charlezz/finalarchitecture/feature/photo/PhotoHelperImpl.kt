package com.charlezz.finalarchitecture.feature.photo

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import android.database.Cursor

class PhotoHelperImpl: PhotoHelper {
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