package com.charlezz.finalarchitecture.di.module.photo

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.database.Cursor
import android.databinding.DataBindingUtil
import android.provider.MediaStore
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.data.photo.PhotoHelper
import com.charlezz.finalarchitecture.databinding.FragmentPhotoBinding
import com.charlezz.finalarchitecture.di.annotation.FragmentScope
import com.charlezz.finalarchitecture.di.annotation.Named
import com.charlezz.finalarchitecture.ui.photo.PhotoAdapter
import com.charlezz.finalarchitecture.ui.photo.PhotoFragment
import com.charlezz.finalarchitecture.ui.photo.PhotoFragmentViewModel
import dagger.Module
import dagger.Provides

@Module
class PhotoFragmentModule{
    @Provides
    @FragmentScope
    fun provideFragmentPhotoBinding(fragment:PhotoFragment): FragmentPhotoBinding {
        return DataBindingUtil.inflate(fragment.layoutInflater,R.layout.fragment_photo, null, false)
    }

    @Provides
    @FragmentScope
    fun providePhotoFragmentViewModel (fragment:PhotoFragment, @Named("photoCursor") cursor: Cursor, photoHelper: PhotoHelper): PhotoFragmentViewModel {
        return ViewModelProviders.of(fragment, object :ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return PhotoFragmentViewModel(cursor,photoHelper) as T
            }
        }).get(PhotoFragmentViewModel::class.java)
    }

    @Provides
    @FragmentScope
    fun providePhotoAdapter() = PhotoAdapter()

    @Provides
    @Named("photoCursor")
    fun providePhotoCursor(context: Context): Cursor {
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = null
        val selection = null
        val selectionArgs = null
        val sortOrder = null
        //skip Paging Query, it's too annoying. It takes not a while by the way.
        //귀찮아서 쿼리 페이징 하는건 패스. 어짜피 얼마 걸리지도 않음.
        return context.contentResolver.query(uri, projection, selection, selectionArgs, sortOrder)
    }

}
