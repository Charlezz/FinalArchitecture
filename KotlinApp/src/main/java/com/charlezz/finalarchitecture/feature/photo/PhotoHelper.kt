package com.charlezz.finalarchitecture.feature.photo

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import android.database.Cursor


interface PhotoHelper{
    fun fetchPhotos(cursor: Cursor): LiveData<PagedList<Photo>>
}