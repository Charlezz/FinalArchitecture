package com.charlezz.android.feature.splash

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.withTransaction
import com.charlezz.android.core.SingleLiveEvent
import com.charlezz.android.db.AppDatabase
import com.charlezz.android.network.CategoryService
import com.charlezz.android.network.UserService
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception
import kotlin.system.measureTimeMillis

class SplashViewModel
@ViewModelInject constructor(
        private val db: AppDatabase,
        private val userService: UserService,
        private val categoryService: CategoryService
) : ViewModel() {
    val initializeEvent = SingleLiveEvent<Unit>()

    fun initialize() {
        Timber.d("initialize")
        viewModelScope.launch {
            try {
                val retrievingCategoriesWork = flow {
                    emit(measureTimeMillis {
                        val categories = categoryService.getCategories()
                        Timber.d("categories : $categories")
                        db.withTransaction {
                            db.categoryDao().deleteAll()
                            db.categoryDao().insertAll(categories)
                        }
                    })
                }

                val retrievingUsersWork = flow {
                    emit(measureTimeMillis {
                        val users = userService.getUsers()
                        Timber.d("getUsers : $users")
                        db.withTransaction {
                            db.userDao().deleteAll()
                            db.userDao().insertAll(users)
                        }
                    })
                }

                retrievingCategoriesWork
                        .zip(retrievingUsersWork) { t1, t2 -> Timber.d("t1 = $t1 , t2=$t2") }
                        .collect {
                            Timber.d("initializeEvent.call()")
                            initializeEvent.call()
                        }

            } catch (e: Exception) {
                Timber.e(e)
                initializeEvent.call()
            }

        }
    }

}