package com.charlezz.javaapp.feature.local;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;

import com.charlezz.javaapp.BR;
import com.charlezz.javaapp.R;
import com.charlezz.javaapp.databinding.ViewPersonBinding;
import com.charlezz.javaapp.di.FragmentScope;
import com.charlezz.javaapp.feature.base.BaseAdapter;
import com.charlezz.javaapp.feature.base.BaseViewHolder;

import javax.inject.Inject;

@FragmentScope
public class UserAdapter extends BaseAdapter<User, UserAdapter.PersonViewHolder> {
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
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PersonViewHolder((ViewPersonBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.view_person, viewGroup, false));
    }

    @NonNull
    @Override
    protected int getViewModelId(int viewType) {
        return BR.data;
    }

    static class PersonViewHolder extends BaseViewHolder<ViewPersonBinding> {

        public PersonViewHolder(@NonNull ViewPersonBinding binding) {
            super(binding);
        }
    }
}
