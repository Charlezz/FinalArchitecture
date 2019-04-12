package com.charlezz.javaapp.feature.remote;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import com.charlezz.javaapp.BR;
import com.charlezz.javaapp.R;
import com.charlezz.javaapp.feature.base.BaseAdapter;

public class RemoteAdapter extends BaseAdapter<Post, RemoteViewHolder> {

    private static DiffUtil.ItemCallback<Post> diffCallback= new DiffUtil.ItemCallback<Post>() {
        @Override
        public boolean areItemsTheSame(@NonNull Post oldPost, @NonNull Post newPost) {
            return oldPost.equals(newPost);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Post oldPost, @NonNull Post newPost) {
            return oldPost.getBody().equals(newPost.getBody())&&
                    oldPost.describeContents() == newPost.describeContents()&&
                    oldPost.getId() == newPost.describeContents() &&
                    oldPost.getTitle().equals(newPost.getTitle()) &&
                    oldPost.getUserId() == newPost.getUserId();
        }
    };

    protected RemoteAdapter() {
        super(diffCallback);
    }

    @NonNull
    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.view_post;
    }

    @NonNull
    @Override
    protected int getViewModelId(int viewType) {
        return BR.post;
    }
}
