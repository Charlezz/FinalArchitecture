package com.charlezz.finalarchitecture.di.module.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.FragmentMainBinding
import com.charlezz.finalarchitecture.di.annotation.FragmentScope
import com.charlezz.finalarchitecture.ui.main.MainActivity
import com.charlezz.finalarchitecture.ui.main.MainFragment
import com.charlezz.finalarchitecture.viewmodel.MainFragmentViewModel
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