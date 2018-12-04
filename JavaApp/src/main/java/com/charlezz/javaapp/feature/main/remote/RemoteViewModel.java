package com.charlezz.javaapp.feature.main.remote;

import android.arch.lifecycle.ViewModel;

public class RemoteViewModel extends ViewModel {

    public interface Repository {
        void getPosts();
    }

    public interface Navigator{

    }
}
