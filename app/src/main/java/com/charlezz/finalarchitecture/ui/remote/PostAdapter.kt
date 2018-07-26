package com.charlezz.finalarchitecture.ui.remote

import android.support.v7.util.DiffUtil
import com.charlezz.finalarchitecture.BR
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.data.remote.Post
import com.charlezz.finalarchitecture.databinding.ViewPostBinding
import com.charlezz.finalarchitecture.ui.base.BaseAdapter
import com.charlezz.finalarchitecture.ui.base.BaseViewHolder

class PostAdapter : BaseAdapter<Post, ViewPostBinding, PostAdapter.PostViewHolder>(BR.data,diffCallback){
    override fun getViewHolderLayoutId(): Int = R.layout.view_post

    inner class PostViewHolder(binding: ViewPostBinding) : BaseViewHolder<ViewPostBinding>(binding)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Post>() {
            override fun areContentsTheSame(oldItem: Post?, newItem: Post?): Boolean {
                return if (oldItem != null && newItem != null){
                    oldItem.id == newItem.id &&
                            oldItem.body == newItem.body &&
                            oldItem.title == newItem.title &&
                            oldItem.userId == newItem.userId
                } else {
                    false
                }
            }

            override fun areItemsTheSame(oldItem: Post?, newItem: Post?): Boolean {
                return oldItem == newItem
            }
        }
    }
}