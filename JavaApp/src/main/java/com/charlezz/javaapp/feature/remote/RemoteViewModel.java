package com.charlezz.javaapp.feature.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class RemoteViewModel extends ViewModel {

    private PostDataSourceFactory factory;
    private LiveData<PagedList<Post>> posts;
    private MutableLiveData<Boolean> isLoaded = new MutableLiveData<>();
    private CompositeDisposable disposables = new CompositeDisposable();

    public RemoteViewModel(PostDataSourceFactory factory){
        this.factory = factory;
        isLoaded.setValue(true);
        disposables.add(PostEventBus.getInstance().getPostEventBus().subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                isLoaded.postValue(aBoolean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                isLoaded.setValue(true);
            }
        }));
    }

    public void loadData(){
        posts = new LivePagedListBuilder<>(factory, new PagedList.Config.Builder().setPageSize(Integer.MAX_VALUE).setInitialLoadSizeHint(1).build())
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

    public LiveData<Boolean> isLoaded(){
        return isLoaded;
    }
}
