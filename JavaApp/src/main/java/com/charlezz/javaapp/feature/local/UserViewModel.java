package com.charlezz.javaapp.feature.local;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import javax.inject.Inject;

public class UserViewModel extends ViewModel {

    public static final String TAG = UserViewModel.class.getSimpleName();
    private LiveData<PagedList<User>> persons;
    private MediatorLiveData<Boolean> isLoaded = new MediatorLiveData<>();

    @Inject
    public UserViewModel(UserDao userDao){
        isLoaded.setValue(false);
        persons = new LivePagedListBuilder<>(userDao.getUsers(),1).build();
        isLoaded.addSource(persons, new Observer<PagedList<User>>() {
            @Override
            public void onChanged(@Nullable PagedList<User> people) {
                isLoaded.setValue(people!=null && !people.isEmpty());
            }
        });
    }

    public LiveData<PagedList<User>> getPersons() {
        return persons;
    }

    public LiveData<Boolean> isLoaded() {
        return isLoaded;
    }

}
