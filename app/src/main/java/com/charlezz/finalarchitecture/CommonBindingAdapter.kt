package com.charlezz.finalarchitecture

import android.arch.paging.PagedList
import android.arch.paging.PagedListAdapter
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView

@BindingAdapter("list")
fun submitList(recyclerView:RecyclerView,pageList:PagedList<Any>){
    val adapter = recyclerView.adapter as PagedListAdapter<Any, *>
    adapter.submitList(pageList)
}