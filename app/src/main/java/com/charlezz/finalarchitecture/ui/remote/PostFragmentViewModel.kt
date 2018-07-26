package com.charlezz.finalarchitecture.ui.remote

import android.arch.lifecycle.AndroidViewModel
import android.arch.paging.LivePagedListBuilder
import com.charlezz.finalarchitecture.App
import com.charlezz.finalarchitecture.data.remote.ApiHelper
import com.charlezz.finalarchitecture.data.remote.PostDataSourceFactory

class PostFragmentViewModel(val app: App, apiHelper:ApiHelper) : AndroidViewModel(app){
    val posts = LivePagedListBuilder(PostDataSourceFactory(apiHelper), 5)
            .setInitialLoadKey(1)
            .build()
}