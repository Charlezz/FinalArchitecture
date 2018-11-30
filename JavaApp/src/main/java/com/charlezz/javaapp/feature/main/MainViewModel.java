package com.charlezz.javaapp.feature.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Navigator> navigator;

    public void setNavigator(Navigator navigator){
        this.navigator.setValue(navigator);
    }

    public LiveData<Navigator> getNavigator(){
        return navigator;
    }

    public interface Navigator{
        void onRemoteClick();
    }

}
