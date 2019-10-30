package com.charlezz.javaapp.feature.base;

import androidx.paging.PagedListAdapter;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

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
