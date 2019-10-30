package com.charlezz.finalarchitecture.feature.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList

class PersonFragmentViewModel(dbHelprer: DBHelper) : ViewModel() {

    val persons:LiveData<PagedList<Person>> = dbHelprer.getPersons()
    val isLoaded = Transformations.switchMap(persons){
        input: PagedList<Person>? ->
        MutableLiveData<Boolean>().apply { value = (input!=null&&input.size!=0) }
    }

}