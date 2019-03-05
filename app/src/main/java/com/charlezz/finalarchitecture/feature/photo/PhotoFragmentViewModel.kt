package com.charlezz.finalarchitecture.feature.photo

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import android.database.Cursor
import com.charlezz.finalarchitecture.data.photo.Photo
import com.charlezz.finalarchitecture.data.photo.PhotoHelper

class PhotoFragmentViewModel(private val cursor: Cursor?, photoHelper: PhotoHelper):ViewModel(){

    var photos: LiveData<PagedList<Photo>> = if (cursor!=null) photoHelper.fetchPhotos(cursor) else MutableLiveData()

    override fun onCleared() {
        super.onCleared()
        cursor?.let {
            if(!it.isClosed){
                it.close()
            }
        }
    }
}