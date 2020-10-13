package com.charlezz.android.core.recyclerview

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T: LayoutAware, VH : BaseViewHolder<*>>
(private val bindingResId: Int)
    : RecyclerView.Adapter<VH>() {

    private val items = ArrayList<T>()

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return object : BaseViewHolder<ViewDataBinding>(viewType, parent) {} as VH
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).getViewType()
    }

    fun getItem(position:Int):T{
        return items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(items:List<T>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}