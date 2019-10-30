package com.charlezz.javaapp.feature.local;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;
import androidx.annotation.Nullable;

public class PersonViewModel extends ViewModel {
    private LiveData<PagedList<Person>> persons;
    private MediatorLiveData<Boolean> isLoaded = new MediatorLiveData<>();

    public PersonViewModel(DBHelper dbHelper){
        isLoaded.setValue(false);
        persons = dbHelper.getPersons();
        isLoaded.addSource(persons, new Observer<PagedList<Person>>() {
            @Override
            public void onChanged(@Nullable PagedList<Person> people) {
                isLoaded.setValue(people!=null && !people.isEmpty());
            }
        });
    }

    public LiveData<PagedList<Person>> getPersons() {
        return persons;
    }

    public LiveData<Boolean> isLoaded() {
        return isLoaded;
    }
}
