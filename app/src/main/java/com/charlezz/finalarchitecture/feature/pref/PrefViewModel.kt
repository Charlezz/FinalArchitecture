package com.charlezz.finalarchitecture.feature.pref

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.charlezz.finalarchitecture.App

class PrefViewModel(val app: App) : AndroidViewModel(app) {
    val data = MutableLiveData<String>()
    init {
        data.value = app.dataManager.getData()
    }

    fun setData(data:String){
        if(app.dataManager.setData(data)){
            this.data.value = data
        }
    }
}