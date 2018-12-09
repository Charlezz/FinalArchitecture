package com.charlezz.javaapp.feature.main.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

public class RemoteViewModel extends ViewModel {

    private Navigator navigator;
    private PostDataSourceFactory factory;
    private LiveData<PagedList<Post>> posts;

    public RemoteViewModel(PostDataSourceFactory factory,Navigator navigator){
        this.navigator = navigator;
        this.factory = factory;
    }

    public void loadData(){
        posts = new LivePagedListBuilder<>(factory, Integer.MAX_VALUE)
                .build();
    }

    public LiveData<PagedList<Post>> getPosts(){
        return posts;
    }

    public interface Navigator{

    }
}
