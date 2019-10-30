package com.charlezz.finalarchitecture.feature.remote

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.FragmentPostBinding
import com.charlezz.finalarchitecture.di.FragmentScope
import dagger.Module
import dagger.Provides

@Suppress("UNCHECKED_CAST")
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
    fun providePostFragmentViewModel(fragment: PostFragment, apiHelper: ApiHelper): PostFragmentViewModel =
            ViewModelProviders.of(fragment, object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return PostFragmentViewModel(apiHelper).apply {
                        posts.observe(fragment, Observer {})
                    } as T
                }
            }).get(PostFragmentViewModel::class.java)

    @Provides
    @FragmentScope
    fun providePostAdapter() = PostAdapter()
}