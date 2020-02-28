package com.charlezz.javaapp.feature.remote;

import android.view.LayoutInflater;

import androidx.databinding.DataBindingUtil;

import com.charlezz.javaapp.R;
import com.charlezz.javaapp.databinding.FragmentRemoteBinding;
import com.charlezz.javaapp.di.scope.FragmentScope;
import com.charlezz.javaapp.util.CommonDataBindingComponent;

import dagger.Module;
import dagger.Provides;

@Module
public class RemoteModule {
    @Provides
    @FragmentScope
    FragmentRemoteBinding provideBinding(RemoteFragment fragment, CommonDataBindingComponent commonDataBindingComponent){
        return DataBindingUtil.inflate(LayoutInflater.from(fragment.getContext()),R.layout.fragment_remote, null, false,commonDataBindingComponent);
    }

}
