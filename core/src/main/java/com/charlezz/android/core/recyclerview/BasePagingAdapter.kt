package com.charlezz.android.core.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.charlezz.android.core.R

abstract class BasePagingAdapter<T: LayoutAware, VH : BaseViewHolder<*>>
(private val bindingResId: Int, diffCallback: DiffUtil.ItemCallback<T>)
    : PagingDataAdapter<T, VH>(diffCallback) {

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return object : BaseViewHolder<ViewDataBinding>(viewType, parent) {} as VH
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.getViewType()?: R.layout.empty_layout

    }
}
