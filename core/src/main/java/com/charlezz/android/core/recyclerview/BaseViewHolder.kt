package com.charlezz.android.core.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<VDB : ViewDataBinding>(
        @LayoutRes layoutResId: Int,
        parent: ViewGroup
) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
) {

    protected val binding: VDB = DataBindingUtil.bind(itemView)!!

    fun onBind(item: LayoutAware?) {
        try {
            item?.let {
                binding.setVariable(it.getBindingResId(), item)
                binding.executePendingBindings()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}