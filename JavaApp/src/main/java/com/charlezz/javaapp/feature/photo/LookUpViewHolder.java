package com.charlezz.javaapp.feature.photo;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;

import com.charlezz.javaapp.feature.base.BaseViewHolder;

import androidx.recyclerview.selection.ItemDetailsLookup;

public class LookUpViewHolder extends BaseViewHolder {

    public LookUpViewHolder(@NonNull ViewDataBinding binding) {
        super(binding);
    }

    public ItemDetailsLookup.ItemDetails<Long> getItemDetails(){
        return new ItemDetailsLookup.ItemDetails<Long>() {
            @Override
            public int getPosition() {
                return getAdapterPosition();
            }

            @Nullable
            @Override
            public Long getSelectionKey() {
                return getItemId();
            }

            @Override
            public boolean inSelectionHotspot(@NonNull MotionEvent e) {
                return true;
            }
        };
    }
}
