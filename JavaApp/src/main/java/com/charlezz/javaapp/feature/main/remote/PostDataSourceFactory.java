package com.charlezz.javaapp.feature.main.remote;

import android.arch.paging.DataSource;

public class PostDataSourceFactory extends DataSource.Factory<Integer, Post> {
    private PostService postService;
    public PostDataSourceFactory(PostService postService){
        this.postService = postService;
    }
    @Override
    public DataSource<Integer, Post> create() {
        return new PostDataSource(postService);
    }
}
