package com.charlezz.finalarchitecture.feature.photo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import android.database.Cursor

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