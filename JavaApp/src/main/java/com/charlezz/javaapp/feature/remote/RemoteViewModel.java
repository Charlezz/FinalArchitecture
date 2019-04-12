package com.charlezz.javaapp.feature.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import io.reactivex.disposables.CompositeDisposable;

public class RemoteViewModel extends ViewModel {

    private PostDataSourceFactory factory;
    private LiveData<PagedList<Post>> posts;
    private CompositeDisposable disposables = new CompositeDisposable();

    public RemoteViewModel(PostDataSourceFactory factory){
        this.factory = factory;
    }

    public void loadData(){
        posts = new LivePagedListBuilder<>(factory, 20)
                .build();
    }

    public LiveData<PagedList<Post>> getPosts(){
        return posts;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if(!disposables.isDisposed()){
            disposables.dispose();
        }
    }
}
