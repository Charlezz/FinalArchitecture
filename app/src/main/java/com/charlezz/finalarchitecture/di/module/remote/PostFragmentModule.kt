package com.charlezz.finalarchitecture.di.module.remote

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.App
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.data.remote.ApiHelper
import com.charlezz.finalarchitecture.databinding.FragmentPostBinding
import com.charlezz.finalarchitecture.di.annotation.FragmentScope
import com.charlezz.finalarchitecture.ui.remote.PostActivity
import com.charlezz.finalarchitecture.ui.remote.PostAdapter
import com.charlezz.finalarchitecture.ui.remote.PostFragment
import com.charlezz.finalarchitecture.ui.remote.PostFragmentViewModel
import dagger.Module
import dagger.Provides

@Module
class PostFragmentModule {
    @Provides
    @FragmentScope
    fun provideFragmentRemoteBinding(activity: PostActivity): FragmentPostBinding =
            DataBindingUtil.inflate(
                    activity.layoutInflater,
                    R.layout.fragment_post,
                    null,
                    false
            )

    @Provides
    @FragmentScope
    fun providePostFragmentViewModel(app: App, fragment: PostFragment, apiHelper: ApiHelper): PostFragmentViewModel =
            ViewModelProviders.of(fragment, object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return PostFragmentViewModel(app, apiHelper).apply {
                        posts.observe(fragment, Observer {})
                    } as T
                }
            }).get(PostFragmentViewModel::class.java)

    @Provides
    @FragmentScope
    fun providePostAdapter() = PostAdapter()
}