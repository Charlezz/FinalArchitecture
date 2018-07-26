package com.charlezz.finalarchitecture.ui.photo

import android.arch.lifecycle.ViewModel
import android.database.Cursor
import com.charlezz.finalarchitecture.data.photo.PhotoHelper

class PhotoFragmentViewModel(private val cursor: Cursor, photoHelper: PhotoHelper):ViewModel(){

    val photos = photoHelper.fetchPhotos(cursor)

    override fun onCleared() {
        super.onCleared()
        if(!cursor.isClosed){
            cursor.close()
        }
    }
}