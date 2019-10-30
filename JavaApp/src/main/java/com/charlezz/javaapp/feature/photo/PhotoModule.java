package com.charlezz.javaapp.feature.photo;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;

import com.charlezz.javaapp.R;
import com.charlezz.javaapp.databinding.FragmentPhotoBinding;
import com.charlezz.javaapp.di.FragmentScope;

import androidx.recyclerview.selection.SelectionPredicates;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StableIdKeyProvider;
import androidx.recyclerview.selection.StorageStrategy;
import dagger.Module;
import dagger.Provides;

@Module
public class PhotoModule {
    @FragmentScope
    @Provides
    static FragmentPhotoBinding provideBinding(PhotoFragment fragment){
        return DataBindingUtil.inflate(LayoutInflater.from(fragment.getContext()), R.layout.fragment_photo,null, false);
    }

    @FragmentScope
    @Provides
    static RecyclerView provideRecyclerView(FragmentPhotoBinding binding){
        return binding.recyclerView;
    }

    @Provides
    @FragmentScope
    static PhotoAdapter provideAdapter(){
        return new PhotoAdapter();
    }


    @Provides
    @FragmentScope
    static PhotoViewModel provideViewModel(PhotoFragment fragment, SelectionTracker<Long> selectionTracker){
        return new PhotoViewModel(fragment.getContext(), selectionTracker);
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
