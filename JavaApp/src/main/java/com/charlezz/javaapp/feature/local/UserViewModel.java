package com.charlezz.javaapp.feature.local;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import javax.inject.Inject;

public class UserViewModel extends ViewModel {

    private LiveData<PagedList<User>> users;
    private UserDao userDao;

    @Inject
    public UserViewModel(UserDao userDao){
        this.userDao = userDao;
    }

    public void load(){
        users = new LivePagedListBuilder<>(userDao.getUsers(),10).build();
    }

    public LiveData<PagedList<User>> getUsers() {
        return users;
    }

    public void generate(){
        new Thread(() -> userDao.insertUser(new User("Runa",String.valueOf(System.currentTimeMillis())))).start();

    }

}
