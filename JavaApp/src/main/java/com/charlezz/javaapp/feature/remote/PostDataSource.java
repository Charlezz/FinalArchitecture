package com.charlezz.javaapp.feature.remote;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PageKeyedDataSource;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Response;

public class PostDataSource extends PageKeyedDataSource<Integer, Post> {

    Pattern LINK_PATTERN = Pattern.compile("<([^>]*)>[\\s]*;[\\s]*rel=\"([a-zA-Z0-9]+)\"");
    Pattern PAGE_PATTERN = Pattern.compile("\\b_page=(\\d+)");
    private PostService postService;

    public PostDataSource(PostService postService) {
        this.postService = postService;
    }


    @Override
    public void loadInitial(
            @NonNull LoadInitialParams<Integer> params,
            @NonNull LoadInitialCallback<Integer, Post> callback) {
        Call<List<Post>> request = postService.getTopPosts();
        try {
            Response<List<Post>> response = request.execute();
            List<Post> items = response.body();
            Integer nextPage = getNextPage(response);
            callback.onResult(items, null, nextPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadBefore(
            @NonNull LoadParams<Integer> params,
            @NonNull LoadCallback<Integer, Post> callback) {
        //do nothing
    }

    @Override
    public void loadAfter(
            @NonNull LoadParams<Integer> params,
            @NonNull LoadCallback<Integer, Post> callback) {
        Call<List<Post>> request = postService.getPosts(params.key);
        try {
            Response<List<Post>> response = request.execute();
            List<Post> items = response.body();
            Integer nextPage = getNextPage(response);
            callback.onResult(items, nextPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, String> extractLink(String str) {
        Matcher matcher = LINK_PATTERN.matcher(str);
        HashMap<String, String> links = new HashMap<>();
        while (matcher.find()) {
            int count = matcher.groupCount();
            if (count == 2) {
                links.put(matcher.group(2), matcher.group(1));
            }
        }
        return links;
    }

    private Integer getNextPage(Response<List<Post>> response) {

        Headers headers = response.headers();
        String linkString = headers.get("link");
        HashMap map = extractLink(linkString);
        String nextUrl = (String) map.get("next");

        if (nextUrl == null) {
            return null;
        }
        Matcher matcher = PAGE_PATTERN.matcher(nextUrl);
        if (!matcher.find() || matcher.groupCount() != 1) {
            return null;
        } else {
            try {
                return Integer.parseInt(matcher.group(1));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    class CustomView extends View {
        public CustomView(Context context) {
            super(context);
        }

        @Nullable
        @Override
        protected Parcelable onSaveInstanceState() {

            return super.onSaveInstanceState();
        }
    }
}
