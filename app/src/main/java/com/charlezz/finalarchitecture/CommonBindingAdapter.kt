package com.charlezz.finalarchitecture

import android.arch.paging.PagedList
import android.arch.paging.PagedListAdapter
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View

@Suppress("UNCHECKED_CAST")
@BindingAdapter("bind:list")
fun <T> submitList(recyclerView: RecyclerView, pageList: PagedList<T>?) {
    pageList?.let {
        val adapter = recyclerView.adapter as PagedListAdapter<T, *>
        adapter.submitList(pageList)
    }
}

@BindingAdapter("bind:isVisible")
fun setVisibility(view: View, isVisible: Boolean){
    if(isVisible){
        view.visibility = View.VISIBLE
    }else{
        view.visibility = View.GONE
    }
}