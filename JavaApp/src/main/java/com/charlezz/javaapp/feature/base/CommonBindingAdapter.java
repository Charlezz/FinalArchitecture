package com.charlezz.javaapp.feature.base;

import android.arch.paging.PagedList;
import android.arch.paging.PagedListAdapter;
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

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
