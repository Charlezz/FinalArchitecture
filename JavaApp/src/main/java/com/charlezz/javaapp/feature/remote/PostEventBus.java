package com.charlezz.javaapp.feature.remote;

import io.reactivex.subjects.PublishSubject;

public class PostEventBus {
    private static PostEventBus instance = new PostEventBus();

    public static PostEventBus getInstance(){
        return instance;
    }

    private PublishSubject<Boolean> bus = PublishSubject.create();

    private PostEventBus(){
    }

    public void send(boolean isLoaded){
        bus.onNext(isLoaded);
    }
    public PublishSubject<Boolean> getPostEventBus(){
        return bus;
    }

}
