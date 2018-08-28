package com.charlezz.finalarchitecture.feature.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Intent
import com.charlezz.finalarchitecture.extension.start
import com.charlezz.finalarchitecture.feature.local.PersonActivity
import com.charlezz.finalarchitecture.feature.photo.PhotoActivity
import com.charlezz.finalarchitecture.feature.pref.PrefActivity
import com.charlezz.finalarchitecture.feature.remote.PostActivity

class MainFragmentViewModel(val app:Application) : AndroidViewModel(app){
    val TAG = MainFragmentViewModel::class.java.simpleName

    fun startPersonActivity(){
        app.startActivity(Intent(app, PersonActivity::class.java))
    }
    fun startPostActivity(){
        app.startActivity(Intent(app, PostActivity::class.java))
    }
    fun startPrefActivity(){
        app.start(PrefActivity::class.java)
    }
    fun startPhotoActivity(){
        app.start(PhotoActivity::class.java)
    }
}