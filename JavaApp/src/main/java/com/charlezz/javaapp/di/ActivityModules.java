package com.charlezz.javaapp.di;

import com.charlezz.javaapp.feature.main.MainActivity;
import com.charlezz.javaapp.feature.main.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModules {
    @ActivityScope
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();
}
