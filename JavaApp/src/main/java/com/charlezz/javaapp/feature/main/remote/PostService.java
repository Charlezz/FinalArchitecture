package com.charlezz.javaapp.feature.main.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PostService {
    @GET("posts")
    Call<List<Post>> getPosts(@Query("_start") long start, @Query("_limit") int limit);
}
