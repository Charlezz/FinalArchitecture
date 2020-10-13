package com.charlezz.android.feature.setting.program

import androidx.lifecycle.ViewModel
import com.charlezz.android.BuildConfig

class ProgramInfoViewModel:ViewModel() {

    fun getVersion():String{
        return BuildConfig.VERSION_NAME
    }


}