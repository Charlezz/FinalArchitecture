package com.charlezz.finalarchitecture.di.module.remote

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.FragmentRemoteBinding
import com.charlezz.finalarchitecture.di.annotation.FragmentScope
import com.charlezz.finalarchitecture.ui.remote.RemoteActivity
import com.charlezz.finalarchitecture.ui.remote.RemoteFragment
import com.charlezz.finalarchitecture.viewmodel.RemoteFragmentViewModel
import dagger.Module
import dagger.Provides

@Module
class RemoteFragmentModule {

    @Provides
    @FragmentScope
    fun provideFragmentRemoteBinding(activity: RemoteActivity): FragmentRemoteBinding =
            DataBindingUtil.inflate(
            activity.layoutInflater,
            R.layout.fragment_remote,
            null,
            false
    )
    @Provides
    @FragmentScope
    fun provideRemoteFragmentViewModel(fragment: RemoteFragment): RemoteFragmentViewModel =
            ViewModelProviders.of(fragment).get(RemoteFragmentViewModel::class.java)
}