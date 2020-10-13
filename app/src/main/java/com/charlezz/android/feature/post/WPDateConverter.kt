package com.charlezz.android.feature.post

import java.text.SimpleDateFormat
import java.util.*

object WPDateConverter {
    private const val pattern = "yyyy-MM-dd'T'HH:mm:ss"
    private val sdf = SimpleDateFormat(pattern)

    fun convert(date: String): Date? = sdf.parse(date)

    fun convert(date: Date): String = sdf.format(date)

    fun currentDate(): String = convert(Date())
}