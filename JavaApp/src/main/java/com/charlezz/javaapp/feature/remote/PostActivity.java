package com.charlezz.javaapp.feature.remote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.charlezz.javaapp.databinding.ActivityPostBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class PostActivity extends DaggerAppCompatActivity {

    @Inject
    ActivityPostBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new PostFragment())
                .commit();
    }
}
