package com.charlezz.javaapp.feature.remote;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charlezz.javaapp.databinding.FragmentRemoteBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class RemoteFragment extends DaggerFragment {

    public static final String TAG = RemoteFragment.class.getSimpleName();

    @Inject
    FragmentRemoteBinding binding;

    @Inject
    RemoteViewModel viewModel;

    @Inject
    RemoteAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setLifecycleOwner(this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        binding.recyclerView.setAdapter(adapter);
        binding.setViewmodel(viewModel);
        viewModel.loadData();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
