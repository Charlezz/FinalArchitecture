package com.charlezz.finalarchitecture.ui

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

open class BaseViewHolder<VDB : ViewDataBinding>(val binding: VDB)
    : RecyclerView.ViewHolder(binding.root)