package com.charlezz.android.core.bindingadapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("applyText")
fun setText(view: TextView, text:CharSequence?){
    view.text = text
}