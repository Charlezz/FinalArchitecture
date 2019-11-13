package com.charlezz.javaapp.feature.local;

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
public class UserAdapter extends BindingPagedListAdapter {
    private static DiffUtil.ItemCallback<User> diffCallback = new DiffUtil.ItemCallback<User>() {
        @Override
        public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.getName().equals(newItem.getBirth()) &&
                    oldItem.getName().equals(newItem.getName());
        }
    };

    @Inject
    public UserAdapter() {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ViewBindingHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewBindingHolder(DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.view_user, viewGroup, false));
    }

    @NonNull
    @Override
    protected int getViewModelId(int viewType) {
        return BR.data;
    }

}
