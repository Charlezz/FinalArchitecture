package com.charlezz.finalarchitecture.di

import com.charlezz.finalarchitecture.feature.local.PersonActivityModule
import com.charlezz.finalarchitecture.feature.main.MainActivityModule
import com.charlezz.finalarchitecture.feature.photo.PhotoActivityModule
import com.charlezz.finalarchitecture.feature.pref.PrefActivityModule
import com.charlezz.finalarchitecture.feature.remote.PostActivityModule
import com.charlezz.finalarchitecture.feature.local.PersonActivity
import com.charlezz.finalarchitecture.feature.main.MainActivity
import com.charlezz.finalarchitecture.feature.photo.PhotoActivity
import com.charlezz.finalarchitecture.feature.pref.PrefActivity
import com.charlezz.finalarchitecture.feature.remote.PostActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun getMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(PersonActivityModule::class)])
    abstract fun getPersonActivity(): PersonActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(PostActivityModule::class)])
    abstract fun getPostActivity(): PostActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(PrefActivityModule::class)])
    abstract fun getPrefActivity():PrefActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(PhotoActivityModule::class)])
    abstract fun getPhotoActivity():PhotoActivity

}
