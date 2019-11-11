package com.charlezz.javaapp.feature.local;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User")
    DataSource.Factory<Integer, User> getUsers();

    @Insert
    void insertUser(User user);
}
