package com.charlezz.finalarchitecture.feature.photo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.database.Cursor
import android.databinding.DataBindingUtil
import android.provider.MediaStore
import android.util.Log
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.FragmentPhotoBinding
import com.charlezz.finalarchitecture.di.FragmentScope
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class PhotoFragmentModule{
    val TAG = PhotoFragmentModule::class.java.simpleName
    @Provides
    @FragmentScope
    fun provideFragmentPhotoBinding(fragment:PhotoFragment): FragmentPhotoBinding {
        return DataBindingUtil.inflate(fragment.layoutInflater,R.layout.fragment_photo, null, false)
    }

    @Provides
    @FragmentScope
    fun providePhotoFragmentViewModel (fragment:PhotoFragment, @Named("photoCursor") cursor: Cursor?, photoHelper: PhotoHelper): PhotoFragmentViewModel {
        return ViewModelProviders.of(fragment, object :ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return PhotoFragmentViewModel(cursor,photoHelper) as T
            }
        }).get(PhotoFragmentViewModel::class.java).apply {
            photos.observe(fragment, Observer {
                Log.e(TAG, "size=${it?.size}")
            })
        }
    }

    @Provides
    @FragmentScope
    fun providePhotoAdapter() = PhotoAdapter()

    @Provides
    @Named("photoCursor")
    fun providePhotoCursor(context: Context): Cursor? {
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = null
        val selection = null
        val selectionArgs = null
        val sortOrder = null
        //skip Paging Query, it's too annoying, which takes not a while by the way.
        return context.contentResolver.query(uri, projection, selection, selectionArgs, sortOrder)
    }

}
