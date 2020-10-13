package com.charlezz.android.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category (
        @PrimaryKey val id:Int,
        val count:Int,
        val description:String,
        val link:String,
        val name:String,
        val slug:String,
        val taxonomy:String,
        val parent:Int
)