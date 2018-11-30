package com.charlezz.javaapp.di;

import com.charlezz.javaapp.feature.main.MainActivity;
import com.charlezz.javaapp.feature.main.MainModule;
import com.charlezz.javaapp.feature.remote.PostActivity;
import com.charlezz.javaapp.feature.remote.PostActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModules {
    @ActivityScope
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = PostActivityModule.class)
    abstract PostActivity postActivity();

}
