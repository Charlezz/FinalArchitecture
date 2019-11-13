package com.charlezz.javaapp.feature.remote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.charlezz.javaapp.databinding.FragmentRemoteBinding;
import com.charlezz.javaapp.di.AppViewModelFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class RemoteFragment extends DaggerFragment {

    @Inject
    FragmentRemoteBinding binding;

    @Inject
    AppViewModelFactory viewModelFactory;

    @Inject
    RemoteAdapter adapter;

    RemoteViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RemoteViewModel.class);
        viewModel.loadData();

        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        binding.recyclerView.setAdapter(adapter);
        binding.setViewmodel(viewModel);
        return binding.getRoot();
    }

}
