package com.charlezz.finalarchitecture.feature.pref

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.R
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