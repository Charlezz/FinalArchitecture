package com.charlezz.android.core.bindingadapter

import android.view.View
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("toolbarTitle")
fun setToolbarTitle(toolbar: Toolbar, charSequence: CharSequence) {
    toolbar.title = charSequence
}

@BindingAdapter("toolbarTitleColor")
fun setToolbarTitleColor(toolbar: Toolbar, color: Int) {
    toolbar.setTitleTextColor(color)
}

@BindingAdapter("toolbarBackgroundColor")
fun setBackgroundColor(toolbar: Toolbar, backgroundColor: Int) {
    toolbar.setBackgroundColor(backgroundColor)
}

@BindingAdapter("toolbarVisible")
fun setVisible(toolbar: Toolbar, visible: Boolean) {
    toolbar.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("toolbarNavIcon", "toolbarNavIconTint", requireAll = false)
fun setToolbarNavigationIcon(toolbar: Toolbar, @DrawableRes iconRes: Int, color: Int?) {
    toolbar.setNavigationIcon(iconRes)
    color?.let {
        toolbar.navigationIcon?.setTint(ContextCompat.getColor(toolbar.context, it))
    }

}

@BindingAdapter("toolbarNavClick")
fun setToolbarNavigationClickListener(toolbar: Toolbar, listener: View.OnClickListener) {
    toolbar.setNavigationOnClickListener(listener)
}
