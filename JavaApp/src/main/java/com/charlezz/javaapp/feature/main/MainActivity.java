package com.charlezz.javaapp.feature.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.charlezz.javaapp.databinding.ActivityMainBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements MainViewModel.Navigator{
    @Inject
    ActivityMainBinding binding;

    @Inject
    MainViewModel viewModel;

    @Inject
    MainViewModel.Navigator navigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(navigator);
    }

    @Override
    public void onRemoteClick() {
        startActivity(new Intent());
    }
}
