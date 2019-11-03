package com.charlezz.javaapp.di;

import com.charlezz.javaapp.App;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ActivityModules.class, AppModule.class})
public interface AppComponent extends AndroidInjector<App> {
    @Component.Factory
    abstract class Factory implements AndroidInjector.Factory<App> {

    }
}
