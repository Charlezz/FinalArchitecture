package com.charlezz.javaapp.feature.base;

import android.arch.paging.PagedListAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class BaseAdapter<D, VH extends BaseViewHolder> extends PagedListAdapter<D, VH> {

    protected BaseAdapter(@NonNull DiffUtil.ItemCallback<D> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return (VH) new BaseViewHolder(DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                getLayoutResId(viewType),
                viewGroup,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        int viewType = getItemViewType(position);
        int viewModelId = getViewModelId(viewType);
        holder.getBinding().setVariable(viewModelId, getItem(position));
        holder.getBinding().executePendingBindings();

    }

    @LayoutRes
    @NonNull
    protected abstract int getLayoutResId(int viewType);

    @NonNull
    protected abstract int getViewModelId(int viewType);
}
