package com.charlezz.javaapp.feature.photo;

import androidx.databinding.ViewDataBinding;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.MotionEvent;

import com.charlezz.javaapp.feature.base.ViewBindingHolder;

import androidx.recyclerview.selection.ItemDetailsLookup;

public class LookUpViewBindingHolder extends ViewBindingHolder {

    public LookUpViewBindingHolder(@NonNull ViewDataBinding binding) {
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
