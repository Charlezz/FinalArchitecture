package com.charlezz.javaapp.feature;

import android.content.Context;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.charlezz.javaapp.R;
import com.charlezz.javaapp.feature.local.UserFragment;
import com.charlezz.javaapp.feature.photo.PhotoFragment;
import com.charlezz.javaapp.feature.remote.RemoteFragment;

public enum MainTabType {
    LOCAL(new UserFragment(), R.string.local),
    REMOTE(new RemoteFragment(),R.string.remote),
    PHOTO(new PhotoFragment(), R.string.photo);


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
