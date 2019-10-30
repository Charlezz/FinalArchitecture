package com.charlezz.finalarchitecture.feature.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<VDB : ViewDataBinding>(val binding: VDB)
    : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root)