package com.charlezz.finalarchitecture.feature.local

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.FragmentPersonBinding
import com.charlezz.finalarchitecture.di.FragmentScope
import dagger.Module
import dagger.Provides

@Suppress("UNCHECKED_CAST")
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
    fun providePersonFragmentViewModel(fragment: PersonFragment, DBHelper: DBHelper): PersonFragmentViewModel =
            ViewModelProviders.of(fragment, object:ViewModelProvider.Factory{
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return PersonFragmentViewModel(DBHelper) as T
                }
            }).get(PersonFragmentViewModel::class.java)

    @Provides
    @FragmentScope
    fun providePersonAdapter() = PersonAdapter()
}