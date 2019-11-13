package com.charlezz.javaapp.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.charlezz.javaapp.feature.local.UserViewModel;
import com.charlezz.javaapp.feature.remote.RemoteViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    abstract ViewModel bindsUserViewModel(UserViewModel userViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RemoteViewModel.class)
    abstract ViewModel bindsRemoteViewModel(RemoteViewModel remoteViewModel);

}
