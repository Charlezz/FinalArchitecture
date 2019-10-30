package com.charlezz.javaapp.feature.local;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface PersonDao {
    @Query("SELECT * FROM person")
    DataSource.Factory<Integer, Person> getPersonSource();
}
