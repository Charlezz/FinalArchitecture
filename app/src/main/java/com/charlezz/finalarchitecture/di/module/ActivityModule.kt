package com.charlezz.finalarchitecture.di.module

import com.charlezz.finalarchitecture.di.annotation.ActivityScope
import com.charlezz.finalarchitecture.di.module.local.PersonActivityModule
import com.charlezz.finalarchitecture.di.module.main.MainActivityModule
import com.charlezz.finalarchitecture.di.module.remote.RemoteActivityModule
import com.charlezz.finalarchitecture.ui.local.PersonActivity
import com.charlezz.finalarchitecture.ui.main.MainActivity
import com.charlezz.finalarchitecture.ui.remote.RemoteActivity
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
    @ContributesAndroidInjector(modules = [(RemoteActivityModule::class)])
    abstract fun getRemoteActivity(): RemoteActivity

}
