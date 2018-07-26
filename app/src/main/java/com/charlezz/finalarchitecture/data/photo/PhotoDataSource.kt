package com.charlezz.finalarchitecture.data.photo

import android.arch.paging.PositionalDataSource
import android.content.Context
import android.database.Cursor
import android.provider.MediaStore

class PhotoDataSource(val context: Context) : PositionalDataSource<Photo>() {
    val TAG = PhotoDataSource::class.java.simpleName

    private var cursor: Cursor

    init {
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = null
        val selection = null
        val selectionArgs = null
        val sortOrder = null
        //skip Paging Query, it's too annoying. It takes not a while by the way.
        //귀찮아서 쿼리 페이징 하는건 패스. 어짜피 얼마 걸리지도 않음.
        cursor = context.contentResolver.query(uri, projection, selection, selectionArgs, sortOrder)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Photo>) {
        val totalCount = cursor.count
        val position = computeInitialLoadPosition(params, totalCount)
        val loadSize = computeInitialLoadSize(params, position, totalCount)
        val photoList = getPhotos(position, position+loadSize)

        callback.onResult(photoList, position,totalCount)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Photo>) {
        val photoList = getPhotos(params.startPosition, params.startPosition+params.loadSize)
        callback.onResult(photoList)
    }

    private fun getPhotos(start:Int, end:Int):ArrayList<Photo>{
        val photoList = ArrayList<Photo>()

        for (index in start until end) {
            if (cursor.moveToNext()) {
                val name = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DISPLAY_NAME))
                val path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA))
                photoList.add(Photo(name, path))
            }else{
                break
            }
        }
        return photoList
    }
}