package com.charlezz.finalarchitecture.ui

import android.arch.paging.PagedListAdapter
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.charlezz.finalarchitecture.BR

open abstract class BaseAdapter<T, VDB : ViewDataBinding, VH : BaseViewHolder<VDB>>
(diffCallback: DiffUtil.ItemCallback<T>)
    : PagedListAdapter<T, VH>(diffCallback) {
    abstract fun getLayoutId():Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = DataBindingUtil.inflate<VDB>(
                LayoutInflater.from(parent.context),
                getLayoutId(),
                parent,
                false)
        return BaseViewHolder(binding) as VH
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.setVariable(BR.data, getItem(position))
    }
}
