package com.charlezz.javaapp.feature.main.remote;

import javax.inject.Inject;

import android.arch.lifecycle.Observer;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charlezz.javaapp.databinding.FragmentRemoteBinding;

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
        binding.getViewmodel().getPosts().observe(this, new Observer<PagedList<Post>>() {
            @Override
            public void onChanged(@Nullable PagedList<Post> posts) {
                Log.e(TAG,"posts size:"+posts.size());
                adapter.submitList(posts);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
