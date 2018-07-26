package com.charlezz.finalarchitecture.di.module.local

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.FragmentPersonBinding
import com.charlezz.finalarchitecture.di.annotation.FragmentScope
import com.charlezz.finalarchitecture.ui.local.PersonActivity
import com.charlezz.finalarchitecture.ui.local.PersonAdapter
import com.charlezz.finalarchitecture.ui.local.PersonFragment
import com.charlezz.finalarchitecture.ui.local.PersonFragmentViewModel
import dagger.Module
import dagger.Provides

@Module
class PersonFragmentModule {
    @Provides
    @FragmentScope
    fun provideFragmentPersonBinding(activity: PersonActivity): FragmentPersonBinding =
            DataBindingUtil.inflate(
                    activity.layoutInflater,
                    R.layout.fragment_person,
                    null,
                    false)

    @Provides
    @FragmentScope
    fun providePersonFragmentViewModel(fragment: PersonFragment): PersonFragmentViewModel =
            ViewModelProviders.of(fragment).get(PersonFragmentViewModel::class.java).apply {
                persons.observe(fragment, Observer{})
                isLoaded.observe(fragment, Observer {})
            }

    @Provides
    @FragmentScope
    fun providePersonAdapter() = PersonAdapter()
}