package com.charlezz.android.network

import com.charlezz.android.db.entity.Category
import retrofit2.http.GET

interface CategoryService {
    @GET("?rest_route=/wp/v2/categories")
    suspend fun getCategories():List<Category>
}