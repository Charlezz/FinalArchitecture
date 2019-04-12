package com.charlezz.finalarchitecture.feature.photo

import android.arch.paging.DataSource
import android.database.Cursor

class PhotoDataSourceFactory(private val cursor: Cursor) : DataSource.Factory<Int, Photo>(){
    override fun create(): DataSource<Int, Photo> {
        return PhotoDataSource(cursor)
    }

}