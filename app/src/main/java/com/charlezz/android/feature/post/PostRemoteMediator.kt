package com.charlezz.android.feature.post

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.charlezz.android.db.AppDatabase
import com.charlezz.android.db.entity.Post
import com.charlezz.android.network.PostService
import timber.log.Timber
import java.lang.IllegalStateException

@OptIn(ExperimentalPagingApi::class)
class PostRemoteMediator(
        private val db: AppDatabase,
        private val api: PostService
) : RemoteMediator<Int, Post>() {

    companion object {
        const val PER_PAGE = 20
    }

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Post>): MediatorResult {
        return when (loadType) {
            LoadType.REFRESH -> refresh()
            LoadType.PREPEND -> loadAfter()
            LoadType.APPEND -> loadBefore()
        }
    }

    private suspend fun refresh(): MediatorResult {
        Timber.d("refresh")
        try {
            val list = api.getPostsBefore(WPDateConverter.currentDate(), PER_PAGE)
            if (list.isNotEmpty()) {
                db.withTransaction {
                    db.postDao().deleteAll()
                    db.postDao().insertAll(list)
                }
            }
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
        return MediatorResult.Success(endOfPaginationReached = true)
    }

    private suspend fun loadBefore(): MediatorResult {
        Timber.d("loadBefore")
        var earliestPost: Post? = null
        db.withTransaction {
            earliestPost = db.postDao().getEarliestPost()
        }

        val earliestDate = earliestPost?.date
                ?: WPDateConverter.currentDate()
        Timber.d("earliestDate = $earliestDate")

        try {
            val list = api.getPostsBefore(earliestDate, PER_PAGE)
            if (list.isNotEmpty()) {
                db.withTransaction {
                    db.postDao().insertAll(list)
                }
            }
            return MediatorResult.Success(endOfPaginationReached = true)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }

    }

    private suspend fun loadAfter(): MediatorResult {
        Timber.d("loadAfter")
        var latestPost: Post? = null
        db.withTransaction {
            latestPost = db.postDao().getLatestPost()
        }

        if (latestPost == null) {
            return MediatorResult.Error(IllegalStateException())
        }

        val latestDate = latestPost!!.date
        try {
            val list = api.getPostsAfter(latestDate, PER_PAGE)
            if (list.isNotEmpty()) {
                db.withTransaction {
                    db.postDao().insertAll(list)
                }
            }
            return MediatorResult.Success(endOfPaginationReached = true)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

}