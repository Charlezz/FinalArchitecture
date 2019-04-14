package com.charlezz.javaapp.feature.remote;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
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
    RemoteViewModel provideRemoteViewModel(RemoteFragment fragment, final PostDataSourceFactory factory){
        return ViewModelProviders.of(fragment, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new RemoteViewModel(factory);
            }
        }).get(RemoteViewModel.class);
    }

    @Provides
    @FragmentScope
    RemoteAdapter provideAdapter(){
        return new RemoteAdapter();
    }

    @Provides
    @FragmentScope
    PostDataSourceFactory provideDataSourceFactory(PostService postService){
        return new PostDataSourceFactory(postService);
    }

}
