package com.charlezz.finalarchitecture.data.photo

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList


interface PhotoHelper{
    fun fetchPhotos(): LiveData<PagedList<Photo>>
}