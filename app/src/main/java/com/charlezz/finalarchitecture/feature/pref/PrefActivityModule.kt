package com.charlezz.finalarchitecture.feature.pref

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.data.pref.PreferencesHelper
import com.charlezz.finalarchitecture.databinding.ActivityPrefBinding
import com.charlezz.finalarchitecture.di.ActivityScope
import dagger.Module
import dagger.Provides

@Suppress("UNCHECKED_CAST")
@Module
abstract class PrefActivityModule{
    @Module
    companion object {
        @JvmStatic
        @Provides
        @ActivityScope
        fun provideActivityPrefBinding(activity: PrefActivity): ActivityPrefBinding =
                DataBindingUtil.setContentView(activity, R.layout.activity_pref)
        @JvmStatic
        @Provides
        @ActivityScope
        fun providePrefViewModel(activity:PrefActivity , prefHelper: PreferencesHelper):PrefViewModel {
            return ViewModelProviders.of(activity, object:ViewModelProvider.Factory{
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return PrefViewModel(prefHelper) as T
                }

            }).get(PrefViewModel::class.java)
        }
    }
}