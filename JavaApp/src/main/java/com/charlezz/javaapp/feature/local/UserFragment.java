package com.charlezz.javaapp.feature.local;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.charlezz.javaapp.databinding.FragmentUserBinding;
import com.charlezz.javaapp.di.AppViewModelFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class UserFragment extends DaggerFragment {

    @Inject
    FragmentUserBinding binding;

    @Inject
    UserAdapter adapter;

    @Inject
    AppViewModelFactory factory;

    UserViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this, factory).get(UserViewModel.class);
        viewModel.load();

        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.recyclerView.setAdapter(adapter);
        binding.setViewModel(viewModel);

        viewModel.getUsers().observe(getViewLifecycleOwner(),
                users -> adapter.submitList(users));

        return binding.getRoot();
    }
}
