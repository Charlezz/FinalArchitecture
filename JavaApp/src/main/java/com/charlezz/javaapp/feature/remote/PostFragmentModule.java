package com.charlezz.javaapp.feature.remote;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;

import com.charlezz.javaapp.R;
import com.charlezz.javaapp.databinding.FragmentPostBinding;
import com.charlezz.javaapp.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

@Module
public class PostFragmentModule {
    @Provides
    @FragmentScope
    FragmentPostBinding provideBinding(PostFragment fragment){
        return DataBindingUtil.inflate(LayoutInflater.from(fragment.getContext()),R.layout.fragment_post, null, false);
    }

    @Provides
    @FragmentScope
    PostAdapter provideAdapter(PostFragment fragment){
        return new PostAdapter();
    }


}
