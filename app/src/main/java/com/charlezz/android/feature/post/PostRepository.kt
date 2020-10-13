package com.charlezz.android.feature.post

import androidx.paging.*
import com.charlezz.android.db.AppDatabase
import com.charlezz.android.network.PostService
import javax.inject.Inject

class PostRepository @Inject constructor(
        private val db: AppDatabase,
        private val api: PostService
) {
    fun getPosts(pageSize: Int) = Pager(
            config = PagingConfig(pageSize = pageSize, enablePlaceholders = false),
            remoteMediator = PostRemoteMediator(db, api)

    ) {
        db.postDao().getPosts()
    }.flow

}