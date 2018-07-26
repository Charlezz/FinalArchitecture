package com.charlezz.finalarchitecture.data

import com.charlezz.finalarchitecture.data.local.DBHelper
import com.charlezz.finalarchitecture.data.photo.PhotoHelper
import com.charlezz.finalarchitecture.data.pref.PreferencesHelper
import com.charlezz.finalarchitecture.data.remote.ApiHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManagerImpl
@Inject
constructor(private val dbHelper: DBHelper,
            private val preferencesHelper: PreferencesHelper,
            private val apiHelper: ApiHelper,
            private val photoHelper: PhotoHelper)
    : DataManager {

    override fun getData() = preferencesHelper.getData()

    override fun setData(data: String) = preferencesHelper.setData(data)

    override fun getPosts(start: Long, limit: Int) = apiHelper.getPosts(start, limit)

    override fun getAllPersons() = dbHelper.getAllPersons()

    override fun fetchPhotos() = photoHelper.fetchPhotos()

}