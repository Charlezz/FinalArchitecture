package com.charlezz.javaapp.feature.main.remote;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;

import com.charlezz.javaapp.R;
import com.charlezz.javaapp.databinding.FragmentRemoteBinding;
import com.charlezz.javaapp.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

@Module
public class RemoteModule {
    @Provides
    @FragmentScope
    FragmentRemoteBinding provideBinding(RemoteFragment fragment){
        return DataBindingUtil.inflate(LayoutInflater.from(fragment.getContext()),R.layout.fragment_remote, null, false);
    }

    @Provides
    @FragmentScope
    RemoteViewModel provideRemoteViewModel(RemoteFragment fragment){
        return ViewModelProviders.of(fragment).get(RemoteViewModel.class);
    }

    @Provides
    @FragmentScope
    RemoteAdapter provideAdapter(){
        return new RemoteAdapter();
    }
}
