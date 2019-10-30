package com.charlezz.javaapp.feature.photo;

import java.util.ArrayList;
import java.util.List;

import androidx.paging.PositionalDataSource;
import android.database.Cursor;
import android.provider.MediaStore;
import androidx.annotation.NonNull;

import androidx.recyclerview.selection.SelectionTracker;

public class PhotoSource extends PositionalDataSource<Photo> {
    private Cursor cursor;
    private SelectionTracker<Long> selectionTracker;
    public PhotoSource(Cursor cursor, SelectionTracker<Long> selectionTracker){
        this.cursor = cursor;
        this.selectionTracker = selectionTracker;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Photo> callback) {
        List<Photo> photoList = getPhotos(0, params.requestedLoadSize);
        callback.onResult(photoList, 0, cursor.getCount());
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Photo> callback) {
        List<Photo> photoList = getPhotos(params.startPosition, params.startPosition+params.loadSize);
        callback.onResult(photoList);
    }

    private List<Photo> getPhotos(int start, int end){
        ArrayList<Photo> photoList = new ArrayList<>();
        for(int i=start;i<end;i++){
            if(cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DISPLAY_NAME));
                String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA));
                photoList.add(new Photo(name, path,selectionTracker));
            }
        }
        return photoList;
    }
}
