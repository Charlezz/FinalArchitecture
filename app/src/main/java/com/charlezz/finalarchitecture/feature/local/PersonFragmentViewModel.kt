package com.charlezz.finalarchitecture.feature.local

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import com.charlezz.finalarchitecture.data.local.DBHelper
import com.charlezz.finalarchitecture.data.local.Person

class PersonFragmentViewModel(dbHelprer: DBHelper) : ViewModel() {

    val persons:LiveData<PagedList<Person>> = dbHelprer.getPersons()
    val isLoaded = Transformations.switchMap(persons){
        input: PagedList<Person>? ->
        MutableLiveData<Boolean>().apply { value = (input!=null&&input.size!=0) }
    }

}