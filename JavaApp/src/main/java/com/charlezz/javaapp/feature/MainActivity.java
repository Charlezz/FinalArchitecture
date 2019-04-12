package com.charlezz.javaapp.feature;

import javax.inject.Inject;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.charlezz.javaapp.databinding.ActivityMainBinding;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
    @Inject
    ActivityMainBinding binding;

    @Inject
    MainViewModel viewModel;

    @Inject
    MainPageAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.viewPager.setAdapter(adapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

}
