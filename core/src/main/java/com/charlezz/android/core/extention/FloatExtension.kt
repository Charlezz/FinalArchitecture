package com.charlezz.android.core.extention

import android.content.Context
import android.util.TypedValue

fun Float.toDp(context:Context):Int{
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, context.resources.displayMetrics).toInt()
}