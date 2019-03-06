package com.charlezz.javaapp.feature.local;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charlezz.javaapp.databinding.FragmentPersonBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class PersonFragment extends DaggerFragment {
    @Inject
    FragmentPersonBinding binding;

    @Inject
    PersonViewModel viewModel;

    @Inject
    PersonAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setLifecycleOwner(this);
        binding.recyclerView.setAdapter(adapter);
        binding.setViewmodel(viewModel);
    }
}
