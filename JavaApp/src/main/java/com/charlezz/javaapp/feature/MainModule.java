package com.charlezz.javaapp.feature;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;

import com.charlezz.javaapp.R;
import com.charlezz.javaapp.databinding.ActivityMainBinding;
import com.charlezz.javaapp.di.ActivityScope;
import com.charlezz.javaapp.di.FragmentScope;
import com.charlezz.javaapp.feature.local.PersonFragment;
import com.charlezz.javaapp.feature.local.PersonModule;
import com.charlezz.javaapp.feature.remote.RemoteFragment;
import com.charlezz.javaapp.feature.remote.RemoteModule;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

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
    static MainPageAdapter provideAdapter(MainActivity activity){
        return new MainPageAdapter(activity, activity.getSupportFragmentManager());
    }


//    @Provides
//    @ActivityScope
//    static InvocationHandler provideInvocationHandler(MainActivity activity){
//        return new MyInvocationHandler(activity);
//    }

//    @Provides
//    @ActivityScope
//    static MainViewModel.Navigator provideNavigator(MainActivity activity, InvocationHandler invocationHandler){
//        return (MainViewModel.Navigator) Proxy.newProxyInstance(activity.getClassLoader(), new Class<?>[]{MainViewModel.Navigator.class}, invocationHandler);
//    }

    @FragmentScope
    @ContributesAndroidInjector(modules = PersonModule.class)
    abstract PersonFragment personFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = RemoteModule.class)
    abstract RemoteFragment remoteFragment();

}
