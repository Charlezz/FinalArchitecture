package com.charlezz.javaapp.feature.remote;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;

import com.charlezz.javaapp.BR;
import com.charlezz.javaapp.R;
import com.charlezz.javaapp.di.FragmentScope;
import com.charlezz.javaapp.feature.base.BindingPagedListAdapter;
import com.charlezz.javaapp.feature.base.ViewBindingHolder;

import javax.inject.Inject;

@FragmentScope
@SuppressWarnings("unchecked")
public class RemoteAdapter extends BindingPagedListAdapter{

    private static DiffUtil.ItemCallback<Post> diffCallback= new DiffUtil.ItemCallback<Post>() {
        @Override
        public boolean areItemsTheSame(@NonNull Post oldPost, @NonNull Post newPost) {
            return oldPost.getId() == newPost.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Post oldPost, @NonNull Post newPost) {
            return oldPost.getBody().equals(newPost.getBody())&&
                    oldPost.describeContents() == newPost.describeContents()&&
                    oldPost.getTitle().equals(newPost.getTitle()) &&
                    oldPost.getUserId() == newPost.getUserId();
        }
    };

    @Inject
    public RemoteAdapter() {
        super(diffCallback);
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public ViewBindingHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewBindingHolder(DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.view_post, viewGroup, false));
    }

    @NonNull
    @Override
    protected int getViewModelId(int viewType) {
        return BR.post;
    }
}
