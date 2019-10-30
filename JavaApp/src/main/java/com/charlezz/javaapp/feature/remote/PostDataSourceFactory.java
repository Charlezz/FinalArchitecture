package com.charlezz.javaapp.feature.remote;

import androidx.paging.DataSource;

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
