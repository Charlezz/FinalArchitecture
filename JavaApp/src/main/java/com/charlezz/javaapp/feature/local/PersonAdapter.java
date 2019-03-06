package com.charlezz.javaapp.feature.local;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import com.charlezz.javaapp.BR;
import com.charlezz.javaapp.R;
import com.charlezz.javaapp.databinding.ViewPersonBinding;
import com.charlezz.javaapp.feature.base.BaseAdapter;
import com.charlezz.javaapp.feature.base.BaseViewHolder;

public class PersonAdapter extends BaseAdapter<Person,PersonAdapter.PersonViewHolder> {
    private static DiffUtil.ItemCallback<Person> diffCallback = new DiffUtil.ItemCallback<Person>() {
        @Override
        public boolean areItemsTheSame(@NonNull Person oldItem, @NonNull Person newItem) {
            return  oldItem.getId() == newItem.getId() &&
                    oldItem.getName().equals(newItem.getBirth()) &&
                    oldItem.getName().equals(newItem.getName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Person oldItem, @NonNull Person newItem) {
            return oldItem.equals(newItem);
        }
    };

    protected PersonAdapter() {
        super(diffCallback);
    }

    @NonNull
    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.view_person;
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
