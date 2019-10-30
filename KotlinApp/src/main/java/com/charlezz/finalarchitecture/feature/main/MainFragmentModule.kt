package com.charlezz.finalarchitecture.feature.main

import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.FragmentMainBinding
import com.charlezz.finalarchitecture.di.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class MainFragmentModule {

    @Provides
    @FragmentScope
    fun provideFragmentMainBinding(activity: MainActivity): FragmentMainBinding =
            DataBindingUtil.inflate(
                    activity.layoutInflater,
                    R.layout.fragment_main,
                    null,
                    false)

    @Provides
    @FragmentScope
    fun provideMainFragmentViewModel(fragment: MainFragment): MainFragmentViewModel =
            ViewModelProviders.of(fragment).get(MainFragmentViewModel::class.java)
}