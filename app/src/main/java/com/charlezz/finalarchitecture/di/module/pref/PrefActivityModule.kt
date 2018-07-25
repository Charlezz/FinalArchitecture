package com.charlezz.finalarchitecture.di.module.pref

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.App
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.ActivityPrefBinding
import com.charlezz.finalarchitecture.di.annotation.ActivityScope
import com.charlezz.finalarchitecture.ui.pref.PrefActivity
import com.charlezz.finalarchitecture.ui.pref.PrefViewModel
import dagger.Module
import dagger.Provides

@Module
abstract class PrefActivityModule{
    @Module
    companion object {
        @JvmStatic
        @Provides
        @ActivityScope
        fun provideActivityPrefBinding(activity: PrefActivity): ActivityPrefBinding =
                DataBindingUtil.setContentView(activity, R.layout.activity_pref)
        @JvmStatic
        @Provides
        @ActivityScope
        fun providePrefViewModel(app: App, activity:PrefActivity ):PrefViewModel {
            return ViewModelProviders.of(activity,object:ViewModelProvider.Factory{
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return PrefViewModel(app) as T
                }

            }).get(PrefViewModel::class.java).apply {
                data.observe(activity, Observer {  })
            }
        }
    }
}