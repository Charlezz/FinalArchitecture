package com.charlezz.javaapp.feature.base;

import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class CommonBindingAdapter {
    @BindingAdapter("bind:list")
    public static void submitList(RecyclerView recyclerView, PagedList pageList){
        if(pageList!=null){
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if(adapter instanceof PagedListAdapter){
                ((PagedListAdapter) adapter).submitList(pageList);
            }
        }

    }
}
