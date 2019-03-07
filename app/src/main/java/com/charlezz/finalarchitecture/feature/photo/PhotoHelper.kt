package com.charlezz.finalarchitecture.feature.photo

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import android.database.Cursor


interface PhotoHelper{
    fun fetchPhotos(cursor: Cursor): LiveData<PagedList<Photo>>
}