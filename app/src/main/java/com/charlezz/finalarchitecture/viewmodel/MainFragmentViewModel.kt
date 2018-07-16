package com.charlezz.finalarchitecture.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Intent
import com.charlezz.finalarchitecture.ui.local.PersonActivity
import com.charlezz.finalarchitecture.ui.remote.RemoteActivity

class MainFragmentViewModel(val app:Application) : AndroidViewModel(app){
    val TAG = MainFragmentViewModel::class.java.simpleName

    fun startPersonActivity(){
        app.startActivity(Intent(app, PersonActivity::class.java))
    }
    fun startRemoteActivity(){
        app.startActivity(Intent(app, RemoteActivity::class.java))
    }
}