package com.charlezz.finalarchitecture.di.module

import com.charlezz.finalarchitecture.di.annotation.ActivityScope
import com.charlezz.finalarchitecture.di.module.local.PersonActivityModule
import com.charlezz.finalarchitecture.di.module.main.MainActivityModule
import com.charlezz.finalarchitecture.di.module.photo.PhotoActivityModule
import com.charlezz.finalarchitecture.di.module.pref.PrefActivityModule
import com.charlezz.finalarchitecture.di.module.remote.PostActivityModule
import com.charlezz.finalarchitecture.ui.local.PersonActivity
import com.charlezz.finalarchitecture.ui.main.MainActivity
import com.charlezz.finalarchitecture.ui.photo.PhotoActivity
import com.charlezz.finalarchitecture.ui.pref.PrefActivity
import com.charlezz.finalarchitecture.ui.remote.PostActivity
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
