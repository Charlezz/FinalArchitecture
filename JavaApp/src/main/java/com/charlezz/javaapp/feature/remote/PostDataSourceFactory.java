package com.charlezz.javaapp.feature.remote;

import androidx.paging.DataSource;

import com.charlezz.javaapp.di.FragmentScope;

import javax.inject.Inject;

@FragmentScope
public class PostDataSourceFactory extends DataSource.Factory<Integer, Post> {
    private PostService postService;
    @Inject
    public PostDataSourceFactory(PostService postService){
        this.postService = postService;
    }
    @Override
    public DataSource<Integer, Post> create() {
        return new PostDataSource(postService);
    }
}
