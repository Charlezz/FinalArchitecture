package com.charlezz.android.db.entity

import androidx.room.TypeConverter

class PostConverter {
    @TypeConverter
    fun convertIntListToString(value: List<Int>): String? {
        return value.joinToString(separator = ",")
    }

    @TypeConverter
    fun convertStringToIntList(value: String): List<Int>? {
        val intList = value.split(delimiters = arrayOf(","), ignoreCase = false, limit = 0)
        return intList.map { it.toInt() }
    }

}