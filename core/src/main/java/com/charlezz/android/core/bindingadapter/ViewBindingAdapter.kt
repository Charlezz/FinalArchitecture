package com.charlezz.android.core.bindingadapter

import android.view.View
import androidx.databinding.BindingAdapter
import com.charlezz.android.core.extention.toDp

@BindingAdapter("paddingLeft", "paddingRight", "paddingTop", "paddingBottom", requireAll = false)
fun setPadding(view: View, left: Float?, top: Float?, right: Float?, bottom: Float?) {
    val left = left?.toDp(view.context) ?: view.paddingLeft
    val top = top?.toDp(view.context) ?: view.paddingTop
    val right = right?.toDp(view.context) ?: view.paddingRight
    val bottom = bottom?.toDp(view.context) ?: view.paddingBottom
    view.setPadding(left, top, right, bottom)
}

@BindingAdapter("padding")
fun setPadding(view: View, padding: Float?) {
    val padding = padding?.toDp(view.context) ?: 0
    view.setPadding(padding, padding, padding, padding)
}

@BindingAdapter("invalidate")
fun setInvalidate(view:View, invalidating:Boolean?){
    invalidating?.let {
        if(it){
            view.invalidate()
        }
    }
}