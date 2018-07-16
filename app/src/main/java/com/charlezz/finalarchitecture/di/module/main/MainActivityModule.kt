package com.charlezz.finalarchitecture.di.module.main

import android.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.di.annotation.ActivityScope
import com.charlezz.finalarchitecture.di.annotation.FragmentScope
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.ActivityMainBinding
import com.charlezz.finalarchitecture.ui.main.MainActivity
import com.charlezz.finalarchitecture.ui.main.MainFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        @ActivityScope
        fun provideMainActivityBinding(activity: MainActivity): ActivityMainBinding {
            return DataBindingUtil.setContentView(activity, R.layout.activity_main)
        }
    }

    @FragmentScope
    @ContributesAndroidInjector(modules = [(MainFragmentModule::class)])
    abstract fun getMainFragment(): MainFragment

}