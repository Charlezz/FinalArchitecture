package com.charlezz.finalarchitecture.data.local.converter

import android.arch.persistence.room.TypeConverter
import com.charlezz.finalarchitecture.data.local.entity.Card
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class MyTypeConverter {
    companion object {
        @JvmStatic
        @TypeConverter
        fun toDate(timestamp: Long): Date = Date(timestamp)

        @JvmStatic
        @TypeConverter
        fun toTimestamp(date: Date): Long = date.time

        @JvmStatic
        @TypeConverter
        fun fromString(value: String): List<Card> {
            val turnsType = object : TypeToken<List<Card>>() {}.type
            return Gson().fromJson(value, turnsType)
        }

        @JvmStatic
        @TypeConverter
        fun fromList(value: List<Card>): String {
            return Gson().toJson(value)
        }
    }
}