package com.charlezz.android.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
        @PrimaryKey val id: Int,
//        val username: String?,
        val name: String,
//        val firstName: String?,
//        val lastName: String?,
//        val email: String?,
//        val url: String?,
//        val description: String?,
//        val link: String,
//        val locale: String?,
//        val nickname: String?,
//        val slug: String?,
//        val registeredDate: String?,
)

//User(id=1, username=null, name=Charlezz, firstName=null, lastName=null, email=null, url=, description=, link=https://www.charlezz.com/?author=1, locale=null, nickname=null, slug=oksisi2, registeredDate=null)