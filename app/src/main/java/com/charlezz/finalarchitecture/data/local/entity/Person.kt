package com.charlezz.finalarchitecture.data.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.charlezz.finalarchitecture.ui.BaseContent

@Entity(tableName = "person")
data class Person
constructor(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val name: String,
        val birth: String
) : BaseContent {
    override fun getContentId(): Long = id
}