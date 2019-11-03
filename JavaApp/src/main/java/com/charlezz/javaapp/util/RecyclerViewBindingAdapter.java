package com.charlezz.javaapp.util;

import androidx.databinding.BindingAdapter;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewBindingAdapter {

    @BindingAdapter("pagedList")
    public void submitList(RecyclerView recyclerView, PagedList pageList){
        if(pageList!=null){
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if(adapter instanceof PagedListAdapter){
                ((PagedListAdapter) adapter).submitList(pageList);
            }
        }

    }
}
