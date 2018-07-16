package com.charlezz.finalarchitecture

import android.arch.paging.PagedList
import android.arch.paging.PagedListAdapter
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView

@Suppress("UNCHECKED_CAST")
@BindingAdapter("bind:list")
fun <T> submitList(recyclerView: RecyclerView, pageList: PagedList<T>?) {
    pageList?.let {
        val adapter = recyclerView.adapter as PagedListAdapter<T, *>
        adapter.submitList(pageList)
    }

}