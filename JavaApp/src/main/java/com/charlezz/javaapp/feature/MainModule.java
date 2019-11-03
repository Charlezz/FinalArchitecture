package com.charlezz.javaapp.feature;

import androidx.databinding.DataBindingUtil;

import com.charlezz.javaapp.R;
import com.charlezz.javaapp.databinding.ActivityMainBinding;
import com.charlezz.javaapp.di.ActivityScope;
import com.charlezz.javaapp.di.FragmentScope;
import com.charlezz.javaapp.feature.local.UserFragment;
import com.charlezz.javaapp.feature.local.UserModule;
import com.charlezz.javaapp.feature.photo.PhotoFragment;
import com.charlezz.javaapp.feature.photo.PhotoModule;
import com.charlezz.javaapp.feature.remote.RemoteFragment;
import com.charlezz.javaapp.feature.remote.RemoteModule;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import io.reactivex.disposables.CompositeDisposable;

@Module
public abstract class MainModule {

    @Provides
    @ActivityScope
    static CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
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

    @FragmentScope
    @ContributesAndroidInjector(modules = UserModule.class)
    abstract UserFragment personFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = RemoteModule.class)
    abstract RemoteFragment remoteFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = PhotoModule.class)
    abstract PhotoFragment photoFragment();

}
