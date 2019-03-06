package com.charlezz.javaapp.feature.local;

import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;

public interface DBHelper {
    LiveData<PagedList<Person>> getPersons();
}
