package com.charlezz.finalarchitecture.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.charlezz.finalarchitecture.App

class PersonFragmentViewModel(application: Application) : AndroidViewModel(application) {

    val persons = LivePagedListBuilder((getApplication() as App).dataManager.getAllPersons(),
            PagedList.Config.Builder()
                    .setPageSize(20)
                    .setEnablePlaceholders(true)
                    .build()
    ).build()
}