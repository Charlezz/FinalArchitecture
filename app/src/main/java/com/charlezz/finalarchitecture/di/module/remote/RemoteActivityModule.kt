package com.charlezz.finalarchitecture.di.module.remote

import android.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.ActivityRemoteBinding
import com.charlezz.finalarchitecture.di.annotation.ActivityScope
import com.charlezz.finalarchitecture.di.annotation.FragmentScope
import com.charlezz.finalarchitecture.ui.remote.RemoteActivity
import com.charlezz.finalarchitecture.ui.remote.RemoteFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class RemoteActivityModule{
    @Module
    companion object {
        @JvmStatic
        @Provides
        @ActivityScope
        fun provideActivityRemoteBinding(activity: RemoteActivity): ActivityRemoteBinding =
                DataBindingUtil.setContentView(activity, R.layout.activity_remote)
    }

    @FragmentScope
    @ContributesAndroidInjector(modules = [(RemoteFragmentModule::class)])
    abstract fun getRemoteFragment(): RemoteFragment

}