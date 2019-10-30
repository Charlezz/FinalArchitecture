package com.charlezz.javaapp.feature.local;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class DBHelperImpl implements DBHelper{
    private PersonDao personDao;

    public DBHelperImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public LiveData<PagedList<Person>> getPersons() {
        return new LivePagedListBuilder<>(
                personDao.getPersonSource(),
                new PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setPageSize(20)
                        .build()
        ).build();
    }
}
