package com.charlezz.finalarchitecture.feature.pref

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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