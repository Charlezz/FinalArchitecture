package com.charlezz.finalarchitecture.ui.photo

import android.arch.lifecycle.ViewModel
import com.charlezz.finalarchitecture.data.DataManager

class PhotoFragmentViewModel(val dataManager:DataManager):ViewModel(){
    val photos =  dataManager.fetchPhotos()

    override fun onCleared() {
        super.onCleared()
        dataManager.releaseCursor()
    }
}