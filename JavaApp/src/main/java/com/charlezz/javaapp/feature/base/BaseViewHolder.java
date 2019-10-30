package com.charlezz.javaapp.feature.base;

import androidx.databinding.ViewDataBinding;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
