package com.charlezz.javaapp.feature.photo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.selection.ItemDetailsLookup;

public class PhotoDetailsLookUp extends ItemDetailsLookup<Long> {

    private RecyclerView recyclerView;
    public PhotoDetailsLookUp(RecyclerView recyclerView){
        this.recyclerView = recyclerView;
    }
    @Nullable
    @Override
    public ItemDetails<Long> getItemDetails(@NonNull MotionEvent motionEvent) {
        View view = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (view != null) {
            LookUpViewBindingHolder viewHolder = (LookUpViewBindingHolder) recyclerView.getChildViewHolder(view);
            return viewHolder.getItemDetails();
        }
        return null;
    }
}
