package com.charlezz.finalarchitecture.di.module.remote

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.util.Log
import com.charlezz.finalarchitecture.App
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.data.remote.ApiHelper
import com.charlezz.finalarchitecture.databinding.FragmentRemoteBinding
import com.charlezz.finalarchitecture.di.annotation.FragmentScope
import com.charlezz.finalarchitecture.ui.remote.RemoteActivity
import com.charlezz.finalarchitecture.ui.remote.RemoteAdapter
import com.charlezz.finalarchitecture.ui.remote.RemoteFragment
import com.charlezz.finalarchitecture.viewmodel.RemoteFragmentViewModel
import dagger.Module
import dagger.Provides

@Module
class RemoteFragmentModule {
val TAG = RemoteFragmentModule::class.java.simpleName
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
    fun provideRemoteFragmentViewModel(app: App, fragment: RemoteFragment, apiHelper: ApiHelper): RemoteFragmentViewModel =
            ViewModelProviders.of(fragment, object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return RemoteFragmentViewModel(app, apiHelper).apply {
                        posts.observe(fragment, Observer {
                            Log.e(TAG,"${it?.size}")
                        })
                    } as T
                }
            }).get(RemoteFragmentViewModel::class.java)

    @Provides
    @FragmentScope
    fun provideRemoteAdapter() = RemoteAdapter()
}