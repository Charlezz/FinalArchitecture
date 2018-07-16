package com.charlezz.finalarchitecture.di.module.local

import android.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.ActivityPersonBinding
import com.charlezz.finalarchitecture.di.annotation.ActivityScope
import com.charlezz.finalarchitecture.di.annotation.FragmentScope
import com.charlezz.finalarchitecture.ui.local.PersonActivity
import com.charlezz.finalarchitecture.ui.local.PersonFragment
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