package com.charlezz.android

import androidx.room.PrimaryKey
import com.charlezz.android.db.AppDatabase
import com.charlezz.android.db.entity.User
import javax.inject.Inject


class UserRepository @Inject constructor(private val db:AppDatabase){

    private val userCache= HashMap<@PrimaryKey Int,User>()

    suspend fun getUser(id:Int):User?{
        return if(userCache.containsKey(id)){
            userCache[id]
        }else{
            db.userDao().getUser(id)
        }

    }
}