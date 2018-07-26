package com.charlezz.finalarchitecture.ui

import android.arch.paging.PagedList
import android.arch.paging.PagedListAdapter
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

val TAG = "BindingAdapters"

@Suppress("UNCHECKED_CAST")
@BindingAdapter("bind:list")
fun <T> submitList(recyclerView: RecyclerView, pageList: PagedList<T>?) {
    pageList?.let {
        val adapter = recyclerView.adapter as PagedListAdapter<T, *>
        adapter.submitList(pageList)
        Log.e(TAG,"submitList")
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

@BindingAdapter("bind:image")
fun setImage(imageView: ImageView, path:String?){
    path?.let {
        Glide.with(imageView).load(it).transition(DrawableTransitionOptions.withCrossFade()).into(imageView)
    }
}