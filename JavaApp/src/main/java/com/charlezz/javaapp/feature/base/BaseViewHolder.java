package com.charlezz.javaapp.feature.base;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

public class BaseViewHolder<VDB extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private VDB binding;
    public BaseViewHolder(@NonNull VDB binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public VDB getBinding() {
        return binding;
    }
}
