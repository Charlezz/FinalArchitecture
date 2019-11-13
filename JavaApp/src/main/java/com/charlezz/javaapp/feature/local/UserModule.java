package com.charlezz.javaapp.feature.local;

import android.view.LayoutInflater;

import androidx.databinding.DataBindingUtil;

import com.charlezz.javaapp.R;
import com.charlezz.javaapp.databinding.FragmentUserBinding;
import com.charlezz.javaapp.di.FragmentScope;
import com.charlezz.javaapp.util.CommonDataBindingComponent;

import dagger.Module;
import dagger.Provides;

@Module
public  class UserModule {
    @Provides
    @FragmentScope
    FragmentUserBinding provideBinding(UserFragment fragment, CommonDataBindingComponent commonDataBindingComponent){
        return DataBindingUtil.inflate(LayoutInflater.from(fragment.getContext()), R.layout.fragment_user, null, false, commonDataBindingComponent);
    }

}
