package com.charlezz.javaapp.feature.remote;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;

import com.charlezz.javaapp.databinding.ActivityPostBinding;
import com.charlezz.javaapp.di.ActivityScope;
import com.charlezz.javaapp.di.FragmentScope;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class PostActivityModule {
    @Provides
    @ActivityScope
    static ActivityPostBinding provideBiding(PostActivity activity){
        return DataBindingUtil.setContentView(activity, R.layout.activity_post);
    }

    @Provides
    @ActivityScope
    static PostViewModel provideViewModel(PostActivity activity){
        return ViewModelProviders.of(activity).get(PostViewModel.class);
    }

    @FragmentScope
    @ContributesAndroidInjector(modules = {PostFragment.class})
    abstract PostFragment postFragment();
}
