package com.charlezz.finalarchitecture.di.module.photo

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.ActivityPhotoBinding
import com.charlezz.finalarchitecture.di.annotation.ActivityScope
import com.charlezz.finalarchitecture.di.annotation.FragmentScope
import com.charlezz.finalarchitecture.ui.photo.PhotoActivity
import com.charlezz.finalarchitecture.ui.photo.PhotoActivityViewModel
import com.charlezz.finalarchitecture.ui.photo.PhotoFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class PhotoActivityModule{
    @Module
    companion object {
        @JvmStatic
        @Provides
        @ActivityScope
        fun provideActivityPhotoBinding(activity:PhotoActivity): ActivityPhotoBinding {
            return DataBindingUtil.setContentView(activity, R.layout.activity_photo)
        }

        @JvmStatic
        @Provides
        @ActivityScope
        fun providePhotoActivityViewModel(activity:PhotoActivity):PhotoActivityViewModel{
            return ViewModelProviders.of(activity).get(PhotoActivityViewModel::class.java)
        }
    }

    @FragmentScope
    @ContributesAndroidInjector(modules = [(PhotoFragmentModule::class)])
    abstract fun getPhotoFragment():PhotoFragment
}
