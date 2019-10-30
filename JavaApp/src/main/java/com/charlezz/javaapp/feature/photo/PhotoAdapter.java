package com.charlezz.javaapp.feature.photo;

import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.charlezz.javaapp.BR;
import com.charlezz.javaapp.R;
import com.charlezz.javaapp.feature.base.BaseAdapter;

public class PhotoAdapter extends BaseAdapter<Photo, LookUpViewHolder> {
    private static DiffUtil.ItemCallback<Photo> diffCallback = new DiffUtil.ItemCallback<Photo>() {
        @Override
        public boolean areItemsTheSame(@NonNull Photo oldPhoto, @NonNull Photo newPhoto) {
            return oldPhoto.hashCode()==newPhoto.hashCode();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Photo oldPhoto, @NonNull Photo newPhoto) {
            return oldPhoto.equals(newPhoto);
        }
    };
    protected PhotoAdapter() {
        super(diffCallback);
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public LookUpViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new LookUpViewHolder(DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.view_photo, viewGroup, false));
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @NonNull
    @Override
    protected int getViewModelId(int viewType) {
        return BR.item;
    }
}
