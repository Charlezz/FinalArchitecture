package com.charlezz.javaapp.feature.main;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import com.charlezz.javaapp.R;
import com.charlezz.javaapp.feature.main.local.LocalFragment;
import com.charlezz.javaapp.feature.main.remote.RemoteFragment;

public enum MainTabType {
    LOCAL(new LocalFragment(), R.string.local),
    REMOTE(new RemoteFragment(),R.string.remote);


    private Fragment fragment;
    @StringRes private int titleResId;
    MainTabType(Fragment fragment, @StringRes int titleResId){
        this.fragment = fragment;
        this.titleResId = titleResId;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public String getTitle(Context context){
        return context.getString(titleResId);
    }
}
