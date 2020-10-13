package com.charlezz.android.core.bindingadapter

import android.webkit.WebView
import androidx.databinding.BindingAdapter

@BindingAdapter("loadData")
fun loadData(webView:WebView, data:String?){
    data?.let {
//        webView.loadUrl("https://charlezz.com")
        webView.loadData(it, "text/html", "UTF-8")

    }

}