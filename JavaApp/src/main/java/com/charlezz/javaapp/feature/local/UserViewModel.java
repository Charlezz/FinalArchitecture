package com.charlezz.javaapp.feature.local;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import javax.inject.Inject;

public class UserViewModel extends ViewModel {

    private LiveData<PagedList<User>> users;
    private MediatorLiveData<Boolean> isLoaded = new MediatorLiveData<>();

    @Inject
    public UserViewModel(UserDao userDao){
        isLoaded.setValue(false);
        users = new LivePagedListBuilder<>(userDao.getUsers(),20).build();
        isLoaded.addSource(users, people -> isLoaded.setValue(people!=null && !people.isEmpty()));
    }

    public LiveData<PagedList<User>> getUsers() {
        return users;
    }

    public LiveData<Boolean> isLoaded() {
        return isLoaded;
    }

}
