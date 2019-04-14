package com.charlezz.javaapp.feature.photo;


import android.arch.paging.DataSource;
import android.database.Cursor;

import androidx.recyclerview.selection.SelectionTracker;

public class PhotoSourceFactory extends DataSource.Factory<Integer,Photo> {
    private Cursor cursor;
    private SelectionTracker<Long> selectionTracker;
    public PhotoSourceFactory(Cursor cursor, SelectionTracker<Long> selectionTracker){
        this.cursor = cursor;
        this.selectionTracker = selectionTracker;
    }

    @Override
    public DataSource<Integer, Photo> create() {
        return new PhotoSource(cursor, selectionTracker);
    }
}
