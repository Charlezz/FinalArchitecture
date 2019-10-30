package com.charlezz.finalarchitecture.feature.remote

import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder

class PostFragmentViewModel(apiHelper: ApiHelper) : ViewModel(){
    val posts = LivePagedListBuilder(PostDataSourceFactory(apiHelper), 20)
            .setInitialLoadKey(1)
            .build()
}