package com.charlezz.finalarchitecture.data

import android.arch.paging.DataSource
import android.content.Context
import com.charlezz.finalarchitecture.data.local.DBHelper
import com.charlezz.finalarchitecture.data.local.Person
import com.charlezz.finalarchitecture.data.pref.PreferencesHelper
import com.charlezz.finalarchitecture.data.remote.ApiHelper
import com.charlezz.finalarchitecture.data.remote.Post
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager
@Inject
constructor(val context: Context,
            val dbHelper: DBHelper,
            val preferencesHelper: PreferencesHelper,
            val apiHelper: ApiHelper)
    : DataManager {
    override fun getData(): String = preferencesHelper.getData()

    override fun setData(data: String): Boolean =preferencesHelper.setData(data)

    override fun getPosts(start: Long, limit: Int): Call<List<Post>> = apiHelper.getPosts(start,limit)

    override fun getAllPersons(): DataSource.Factory<Int, Person> = dbHelper.getAllPersons()

}