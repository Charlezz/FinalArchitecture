package com.charlezz.finalarchitecture.data.photo

import android.arch.paging.DataSource
import android.content.Context

class PhotoDataSourceFactory(val context:Context) : DataSource.Factory<Int,Photo>(){
    override fun create(): DataSource<Int, Photo> {
        return PhotoDataSource(context)
    }

}