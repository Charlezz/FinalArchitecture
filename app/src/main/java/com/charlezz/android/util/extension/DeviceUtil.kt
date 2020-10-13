package com.charlezz.android.util.extension

import android.content.pm.PackageManager
import android.os.Build

object DeviceUtil{
    fun isLGDevice(): Boolean {
        return Build.BRAND != null && Build.BRAND == "lge"
    }

    fun isPackageInstalled(packageName: String, packageManager: PackageManager): Boolean {
        return try {
            packageManager.getPackageInfo(packageName, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }
}