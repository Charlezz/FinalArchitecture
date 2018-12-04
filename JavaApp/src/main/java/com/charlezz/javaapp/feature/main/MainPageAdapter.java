package com.charlezz.javaapp.feature.main;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MainPageAdapter extends FragmentStatePagerAdapter {
    private Context context;
    public MainPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return MainTabType.values()[position].getFragment();
    }

    @Override
    public int getCount() {
        return MainTabType.values().length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return MainTabType.values()[position].getTitle(context);
    }
}
