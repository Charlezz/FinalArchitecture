package com.charlezz.android.util.extension

import android.app.Activity
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import android.view.View

fun Activity.setImmersiveStickyMode() {
    this.window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN or
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
}

fun AppCompatActivity.replaceFragment(@IdRes id: Int, supportFragment: androidx.fragment.app.Fragment) {
    supportFragmentManager.beginTransaction()
            .replace(id, supportFragment)
            .commitNow()
}
