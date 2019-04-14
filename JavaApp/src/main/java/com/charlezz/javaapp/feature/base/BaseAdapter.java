package com.charlezz.javaapp.feature.base;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

public abstract class BaseAdapter<D, VH extends BaseViewHolder> extends PagedListAdapter<D, VH> {

    protected BaseAdapter(@NonNull DiffUtil.ItemCallback<D> diffCallback) {
        super(diffCallback);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        int viewType = getItemViewType(position);
        int viewModelId = getViewModelId(viewType);
        holder.getBinding().setVariable(viewModelId, getItem(position));
        holder.getBinding().executePendingBindings();

    }

    @NonNull
    protected abstract int getViewModelId(int viewType);
}
