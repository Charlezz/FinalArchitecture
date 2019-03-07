package com.charlezz.finalarchitecture.feature.remote

import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder

class PostFragmentViewModel(apiHelper: ApiHelper) : ViewModel(){
    val posts = LivePagedListBuilder(PostDataSourceFactory(apiHelper), 20)
            .setInitialLoadKey(1)
            .build()
}