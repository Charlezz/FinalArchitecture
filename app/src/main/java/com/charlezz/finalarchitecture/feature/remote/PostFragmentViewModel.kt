package com.charlezz.finalarchitecture.feature.remote

import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import com.charlezz.finalarchitecture.data.remote.ApiHelper
import com.charlezz.finalarchitecture.data.remote.PostDataSourceFactory

class PostFragmentViewModel(apiHelper:ApiHelper) : ViewModel(){
    val posts = LivePagedListBuilder(PostDataSourceFactory(apiHelper), 5)
            .setInitialLoadKey(1)
            .build()
}