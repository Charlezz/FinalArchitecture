package com.charlezz.finalarchitecture.di.module.photo

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.data.DataManager
import com.charlezz.finalarchitecture.databinding.FragmentPhotoBinding
import com.charlezz.finalarchitecture.di.annotation.FragmentScope
import com.charlezz.finalarchitecture.ui.photo.PhotoAdapter
import com.charlezz.finalarchitecture.ui.photo.PhotoFragment
import com.charlezz.finalarchitecture.ui.photo.PhotoFragmentViewModel
import dagger.Module
import dagger.Provides

@Module
class PhotoFragmentModule(){
    @Provides
    @FragmentScope
    fun provideFragmentPhotoBinding(fragment:PhotoFragment): FragmentPhotoBinding {
        return DataBindingUtil.inflate(fragment.layoutInflater,R.layout.fragment_photo, null, false)
    }

    @Provides
    @FragmentScope
    fun providePhotoFragmentViewModel(dataManager: DataManager, fragment:PhotoFragment): PhotoFragmentViewModel {
        return ViewModelProviders.of(fragment, object :ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return PhotoFragmentViewModel(dataManager) as T
            }
        }).get(PhotoFragmentViewModel::class.java)
    }

    @Provides
    @FragmentScope
    fun providePhotoAdapter() = PhotoAdapter()

}
