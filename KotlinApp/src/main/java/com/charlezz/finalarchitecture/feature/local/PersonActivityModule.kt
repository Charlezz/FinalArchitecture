package com.charlezz.finalarchitecture.feature.local

import androidx.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.ActivityPersonBinding
import com.charlezz.finalarchitecture.di.ActivityScope
import com.charlezz.finalarchitecture.di.FragmentScope
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class PersonActivityModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        @ActivityScope
        fun provideActivityPersonBinding(activity: PersonActivity): ActivityPersonBinding =
                DataBindingUtil.setContentView(activity, R.layout.activity_person)
    }

    @FragmentScope
    @ContributesAndroidInjector(modules = [(PersonFragmentModule::class)])
    abstract fun getPersonFragment(): PersonFragment

}