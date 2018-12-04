package com.charlezz.javaapp.feature.main.remote;

import javax.inject.Inject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charlezz.javaapp.databinding.FragmentRemoteBinding;

import dagger.android.support.DaggerFragment;

public class RemoteFragment extends DaggerFragment {

    @Inject
    FragmentRemoteBinding binding;

    @Inject
    RemoteViewModel sharedViewModel;

    @Inject
    RemoteAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
