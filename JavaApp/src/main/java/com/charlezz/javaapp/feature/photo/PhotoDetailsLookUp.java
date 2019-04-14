package com.charlezz.javaapp.feature.photo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
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
            LookUpViewHolder viewHolder = (LookUpViewHolder) recyclerView.getChildViewHolder(view);
            return viewHolder.getItemDetails();
        }
        return null;
    }
}
