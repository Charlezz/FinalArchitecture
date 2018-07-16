package com.charlezz.finalarchitecture

import android.content.Context
import android.support.multidex.MultiDex
import com.charlezz.finalarchitecture.data.DataManager
import com.charlezz.finalarchitecture.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class App : DaggerApplication() {

    @Inject
    lateinit var dataManager:DataManager


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}