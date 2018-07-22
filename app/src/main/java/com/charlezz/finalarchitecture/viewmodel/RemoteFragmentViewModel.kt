package com.charlezz.finalarchitecture.viewmodel

import android.arch.lifecycle.AndroidViewModel
import android.arch.paging.LivePagedListBuilder
import com.charlezz.finalarchitecture.App
import com.charlezz.finalarchitecture.data.remote.ApiHelper
import com.charlezz.finalarchitecture.data.remote.PostDataSourceFactory

class RemoteFragmentViewModel(val app: App, apiHelper:ApiHelper) : AndroidViewModel(app){
    val posts = LivePagedListBuilder(PostDataSourceFactory(apiHelper), 20)
            .setInitialLoadKey(1)
            .build()
}