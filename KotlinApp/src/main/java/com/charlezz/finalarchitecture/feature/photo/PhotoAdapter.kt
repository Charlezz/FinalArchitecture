package com.charlezz.finalarchitecture.feature.photo

import androidx.recyclerview.widget.DiffUtil
import com.charlezz.finalarchitecture.BR
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.ViewPhotoBinding
import com.charlezz.finalarchitecture.feature.base.BaseAdapter
import com.charlezz.finalarchitecture.feature.base.BaseViewHolder

class PhotoAdapter : BaseAdapter<Photo, ViewPhotoBinding, PhotoAdapter.PhotoViewHolder>(BR.photo, diffCallback){

    override fun getViewHolderLayoutId(): Int = R.layout.view_photo

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Photo>() {
            override fun areContentsTheSame(oldItem: Photo, newItem: Photo)= oldItem.name == newItem.name && oldItem.path == newItem.path
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo) = oldItem == newItem
        }
    }

    inner class PhotoViewHolder(binding:ViewPhotoBinding):BaseViewHolder<ViewPhotoBinding>(binding)
}