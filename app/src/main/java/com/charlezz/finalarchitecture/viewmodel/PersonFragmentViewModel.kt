package com.charlezz.finalarchitecture.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.charlezz.finalarchitecture.App
import com.charlezz.finalarchitecture.data.local.entity.Person

class PersonFragmentViewModel(application: Application) : AndroidViewModel(application) {

    val persons = LivePagedListBuilder((getApplication() as App).dataManager.getAllPersons(),
            PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPageSize(20)
                    .build()
    ).build()
    val isLoaded = Transformations.switchMap(persons){
        input: PagedList<Person>? ->
        MutableLiveData<Boolean>().apply { value = (input!=null&&input.size!=0) }
    }
}