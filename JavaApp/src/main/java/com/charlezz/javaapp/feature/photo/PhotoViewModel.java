package com.charlezz.javaapp.feature.photo;

import android.app.Application;
import android.database.Cursor;
import android.provider.MediaStore;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.selection.SelectionTracker;

import javax.inject.Inject;

import lombok.Getter;


@Getter
public class PhotoViewModel extends AndroidViewModel {

    private LiveData<PagedList<Photo>> photoList;

    @Inject
    public PhotoViewModel(Application application, SelectionTracker<Long> selectionTracker) {
        super(application);
        Cursor cursor = application.getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{
                        MediaStore.Images.Media.DISPLAY_NAME,
                        MediaStore.Images.Media.DATA
                },
                null,
                null,
                null
        );
        PhotoSourceFactory photoSourceFactory = new PhotoSourceFactory(cursor,selectionTracker);
        photoList = new LivePagedListBuilder<>(photoSourceFactory, 30).build();
    }
}