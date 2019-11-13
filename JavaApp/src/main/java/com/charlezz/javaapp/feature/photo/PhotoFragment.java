package com.charlezz.javaapp.feature.photo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.GridLayoutManager;

import com.charlezz.javaapp.databinding.FragmentPhotoBinding;

import javax.inject.Inject;

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
