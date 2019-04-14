package com.charlezz.javaapp.feature.photo;

import javax.inject.Inject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charlezz.javaapp.databinding.FragmentPhotoBinding;

import androidx.recyclerview.selection.SelectionTracker;
import dagger.android.support.DaggerFragment;

public class PhotoFragment extends DaggerFragment {

    @Inject
    FragmentPhotoBinding binding;

    @Inject
    PhotoAdapter adapter;

    @Inject
    PhotoViewModel photoViewModel;

    @Inject
    SelectionTracker<Long> selectionTracker;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.setLifecycleOwner(this);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        binding.setViewmodel(photoViewModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return binding.getRoot();
    }

}
