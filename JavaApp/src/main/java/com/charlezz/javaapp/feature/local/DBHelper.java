package com.charlezz.javaapp.feature.local;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

public interface DBHelper {
    LiveData<PagedList<Person>> getPersons();
}
