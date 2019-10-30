package com.charlezz.javaapp.feature.photo;

import androidx.databinding.ViewDataBinding;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
