package com.charlezz.android.feature

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped

@InstallIn(ActivityComponent::class)
@Module
object MainActivityModule {

    @Provides
    @ActivityScoped
    fun provideToolbarViewModel(activity:FragmentActivity): ToolbarViewModel {
        return ViewModelProvider(activity, activity.defaultViewModelProviderFactory).get(ToolbarViewModel::class.java)
    }

    @Provides
    @ActivityScoped
    fun provideOptionMenuViewModel(activity:FragmentActivity): OptionMenuViewModel {
        return ViewModelProvider(activity, activity.defaultViewModelProviderFactory).get(OptionMenuViewModel::class.java)
    }

}