package com.charlezz.finalarchitecture.feature.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

abstract class BaseViewHolder<VDB : ViewDataBinding>(val binding: VDB)
    : RecyclerView.ViewHolder(binding.root)