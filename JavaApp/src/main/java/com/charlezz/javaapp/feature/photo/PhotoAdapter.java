package com.charlezz.javaapp.feature.photo;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;

import com.charlezz.javaapp.BR;
import com.charlezz.javaapp.R;
import com.charlezz.javaapp.feature.base.BindingPagedListAdapter;
import com.charlezz.javaapp.util.CommonDataBindingComponent;

import javax.inject.Inject;

public class PhotoAdapter extends BindingPagedListAdapter<Photo, LookUpViewBindingHolder> {
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

    private final CommonDataBindingComponent commonDataBindingComponent;

    @Inject
    public PhotoAdapter(CommonDataBindingComponent commonDataBindingComponent) {
        super(diffCallback);
        setHasStableIds(true);
        this.commonDataBindingComponent = commonDataBindingComponent;
    }

    @NonNull
    @Override
    public LookUpViewBindingHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new LookUpViewBindingHolder(DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.view_photo, viewGroup, false, commonDataBindingComponent));
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
