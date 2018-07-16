package com.charlezz.finalarchitecture.extension

import android.app.Activity
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View

fun Activity.setImmersiveStickyMode() {
    this.window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN or
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
}

fun AppCompatActivity.replaceFragment(@IdRes id: Int, supportFragment: Fragment) {
    supportFragmentManager.beginTransaction()
            .replace(id, supportFragment)
            .commitNow()
}
