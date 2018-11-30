package com.charlezz.javaapp.feature.main;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;

import com.charlezz.javaapp.R;
import com.charlezz.javaapp.databinding.ActivityMainBinding;
import com.charlezz.javaapp.di.ActivityScope;
import com.charlezz.javaapp.di.MyInvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainModule {
    @Provides
    @ActivityScope
    static MainViewModel provideViewModel(MainActivity activity){
        return ViewModelProviders.of(activity).get(MainViewModel.class);
    }

    @Provides
    @ActivityScope
    static ActivityMainBinding provideBinding(MainActivity activity){
        return DataBindingUtil.setContentView(activity, R.layout.activity_main);
    }


    @Provides
    @ActivityScope
    static InvocationHandler provideInvocationHandler(MainActivity activity){
        return new MyInvocationHandler(activity);
    }

    @Provides
    @ActivityScope
    static MainViewModel.Navigator provideNavigator(MainActivity activity, InvocationHandler invocationHandler){
        return (MainViewModel.Navigator) Proxy.newProxyInstance(activity.getClassLoader(), new Class<?>[]{MainViewModel.Navigator.class}, invocationHandler);
    }

}
