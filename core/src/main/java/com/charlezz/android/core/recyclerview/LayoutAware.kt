package com.charlezz.android.core.recyclerview

interface LayoutAware {
    fun getViewType(): Int

    fun getBindingResId():Int
}