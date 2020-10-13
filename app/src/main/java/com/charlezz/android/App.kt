package com.charlezz.android

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }else{
            //analytics
        }
        MultiDex.install(this)
    }
}