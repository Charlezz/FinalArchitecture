package com.charlezz.finalarchitecture.di.module.remote

import android.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.ActivityPostBinding
import com.charlezz.finalarchitecture.di.annotation.ActivityScope
import com.charlezz.finalarchitecture.di.annotation.FragmentScope
import com.charlezz.finalarchitecture.ui.remote.PostActivity
import com.charlezz.finalarchitecture.ui.remote.PostFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class PostActivityModule{
    @Module
    companion object {
        @JvmStatic
        @Provides
        @ActivityScope
        fun provideActivityPostBinding(activity: PostActivity): ActivityPostBinding =
                DataBindingUtil.setContentView(activity, R.layout.activity_post)
    }

    @FragmentScope
    @ContributesAndroidInjector(modules = [(PostFragmentModule::class)])
    abstract fun getPostFragment(): PostFragment

}