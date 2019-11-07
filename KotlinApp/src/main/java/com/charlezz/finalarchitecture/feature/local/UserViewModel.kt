package com.charlezz.finalarchitecture.feature.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import javax.inject.Inject


class UserViewModel @Inject constructor(personDao: UserDao) : ViewModel() {
    val persons:LiveData<PagedList<User>> = LivePagedListBuilder(personDao.getPersonSource(), 10).build()
    val isLoaded = Transformations.switchMap(persons){
        input: PagedList<User>? ->
        MutableLiveData<Boolean>().apply { value = (input!=null&&input.size!=0) }
    }
}