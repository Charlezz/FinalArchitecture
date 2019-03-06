package com.charlezz.javaapp.feature.local;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

@Dao
public interface PersonDao {
    @Query("SELECT * FROM person")
    DataSource.Factory<Integer, Person> getPersonSource();
}
