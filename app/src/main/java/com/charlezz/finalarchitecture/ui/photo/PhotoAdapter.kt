package com.charlezz.finalarchitecture.ui.photo

import android.support.v7.util.DiffUtil
import com.charlezz.finalarchitecture.BR
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.data.photo.Photo
import com.charlezz.finalarchitecture.databinding.ViewPhotoBinding
import com.charlezz.finalarchitecture.ui.base.BaseAdapter
import com.charlezz.finalarchitecture.ui.base.BaseViewHolder

class PhotoAdapter : BaseAdapter<Photo, ViewPhotoBinding, PhotoAdapter.PhotoViewHolder>(BR.photo, diffCallback){

    override fun getViewHolderLayoutId(): Int = R.layout.view_photo

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Photo>() {
            override fun areContentsTheSame(oldItem: Photo?, newItem: Photo?): Boolean {
                return if (oldItem != null && newItem != null){
                    oldItem.name == newItem.name &&
                            oldItem.path == newItem.path
                } else {
                    false
                }
            }

            override fun areItemsTheSame(oldItem: Photo?, newItem: Photo?): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class PhotoViewHolder(binding:ViewPhotoBinding):BaseViewHolder<ViewPhotoBinding>(binding)
}