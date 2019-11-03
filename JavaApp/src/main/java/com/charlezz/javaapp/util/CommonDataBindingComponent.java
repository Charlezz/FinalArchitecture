package com.charlezz.javaapp.util;

import javax.inject.Inject;

public class CommonDataBindingComponent implements androidx.databinding.DataBindingComponent {
    private final RecyclerViewBindingAdapter recyclerViewBindingAdapter;
    private final ImageBindingAdapter imageBindingAdapter;
    @Inject
    public CommonDataBindingComponent(){
        recyclerViewBindingAdapter = new RecyclerViewBindingAdapter();
        imageBindingAdapter = new ImageBindingAdapter();
    }

    public RecyclerViewBindingAdapter getRecyclerViewBindingAdapter() {
        return recyclerViewBindingAdapter;
    }

    public ImageBindingAdapter getImageBindingAdapter(){
        return imageBindingAdapter;
    }
}
