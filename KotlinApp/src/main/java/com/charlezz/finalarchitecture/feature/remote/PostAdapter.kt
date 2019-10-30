package com.charlezz.finalarchitecture.feature.remote

import androidx.recyclerview.widget.DiffUtil
import com.charlezz.finalarchitecture.BR
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.ViewPostBinding
import com.charlezz.finalarchitecture.feature.base.BaseAdapter
import com.charlezz.finalarchitecture.feature.base.BaseViewHolder

class PostAdapter : BaseAdapter<Post, ViewPostBinding, PostAdapter.PostViewHolder>(BR.data,diffCallback){
    override fun getViewHolderLayoutId(): Int = R.layout.view_post

    inner class PostViewHolder(binding: ViewPostBinding) : BaseViewHolder<ViewPostBinding>(binding)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Post>() {
            override fun areContentsTheSame(oldItem: Post, newItem: Post)=oldItem.id == newItem.id &&
                    oldItem.body == newItem.body &&
                    oldItem.title == newItem.title &&
                    oldItem.userId == newItem.userId

            override fun areItemsTheSame(oldItem: Post, newItem: Post)=oldItem == newItem
        }
    }
}