package com.charlezz.finalarchitecture.di

import com.charlezz.finalarchitecture.App
import com.charlezz.finalarchitecture.di.module.ActivityModule
import com.charlezz.finalarchitecture.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (ActivityModule::class), (AppModule::class)])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}