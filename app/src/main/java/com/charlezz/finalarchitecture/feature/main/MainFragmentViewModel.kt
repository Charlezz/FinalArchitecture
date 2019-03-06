package com.charlezz.finalarchitecture.feature.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData

class MainFragmentViewModel(val app:Application) : AndroidViewModel(app){
    val clickEvent = MutableLiveData<MainMenu>()

    fun onClick(mainMenu:MainMenu){
        clickEvent.value = mainMenu
    }


}
