package com.charlezz.finalarchitecture.feature.local

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.data.DataManager
import com.charlezz.finalarchitecture.data.DataManagerImpl
import com.charlezz.finalarchitecture.databinding.FragmentPersonBinding
import com.charlezz.finalarchitecture.di.FragmentScope
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
    fun providePersonFragmentViewModel(fragment: PersonFragment,dataManager: DataManager): PersonFragmentViewModel =
            ViewModelProviders.of(fragment, object:ViewModelProvider.Factory{
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return PersonFragmentViewModel(dataManager as DataManagerImpl) as T
                }
            }).get(PersonFragmentViewModel::class.java).apply {
                persons.observe(fragment, Observer{})
                isLoaded.observe(fragment, Observer {})
            }

    @Provides
    @FragmentScope
    fun providePersonAdapter() = PersonAdapter()
}