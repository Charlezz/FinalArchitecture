package com.charlezz.javaapp.feature.local;

import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

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
