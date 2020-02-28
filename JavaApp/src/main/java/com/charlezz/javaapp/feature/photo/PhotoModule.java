package com.charlezz.javaapp.feature.photo;

import android.view.LayoutInflater;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.selection.SelectionPredicates;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StableIdKeyProvider;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.RecyclerView;

import com.charlezz.javaapp.R;
import com.charlezz.javaapp.databinding.FragmentPhotoBinding;
import com.charlezz.javaapp.di.scope.FragmentScope;
import com.charlezz.javaapp.util.CommonDataBindingComponent;

import dagger.Module;
import dagger.Provides;

@Module
public class PhotoModule {
    @FragmentScope
    @Provides
    static FragmentPhotoBinding provideBinding(PhotoFragment fragment, CommonDataBindingComponent commonDataBindingComponent){
        return DataBindingUtil.inflate(LayoutInflater.from(fragment.getContext()), R.layout.fragment_photo,null, false, commonDataBindingComponent);
    }

    @FragmentScope
    @Provides
    static RecyclerView provideRecyclerView(FragmentPhotoBinding binding){
        return binding.recyclerView;
    }

    @FragmentScope
    @Provides
    static SelectionTracker<Long> provideSelectionTracker(RecyclerView recyclerView, PhotoAdapter adapter){
        recyclerView.setAdapter(adapter);
        return new SelectionTracker.Builder<>(
                "selection_id",
                recyclerView,
                new StableIdKeyProvider(recyclerView),
                new PhotoDetailsLookUp(recyclerView),
                StorageStrategy.createLongStorage())
                .withSelectionPredicate(SelectionPredicates.<Long>createSelectAnything())
                .build();
    }

}
