package com.charlezz.finalarchitecture.feature.pref

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class PrefViewModel(private val prefHelper: PreferencesHelper) : ViewModel() {
    val data = MutableLiveData<String>()

    init {
        data.value = prefHelper.getData()
    }

    fun setData(data:String){
        if(prefHelper.setData(data)){
            this.data.value = data
        }
    }
}