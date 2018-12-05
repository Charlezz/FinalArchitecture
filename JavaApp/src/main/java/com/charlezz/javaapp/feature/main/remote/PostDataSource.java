package com.charlezz.javaapp.feature.main.remote;

import java.io.IOException;
import java.util.List;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Response;

public class PostDataSource extends PageKeyedDataSource<Integer, Post> {
    private PostService postService;

    public PostDataSource(PostService postService){
        this.postService = postService;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Post> callback) {
        Call<List<Post>> request = postService.getPosts (1);
        try {
            Response<List<Post>> response = request.execute();
            List<Post> items = response.body();
            callback.onResult(items,1,2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Post> callback) {
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Post> callback) {

        Call<List<Post>> request = postService.getPosts(params.key);
        try {
            Response<List<Post>> response = request.execute();
            List<Post> items = response.body();
            int nextPage = 3;
            callback.onResult(items, nextPage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
