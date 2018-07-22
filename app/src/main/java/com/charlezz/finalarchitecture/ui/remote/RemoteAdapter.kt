package com.charlezz.finalarchitecture.ui.remote

import android.support.v7.util.DiffUtil
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.data.remote.Post
import com.charlezz.finalarchitecture.databinding.ViewRemoteBinding
import com.charlezz.finalarchitecture.ui.base.BaseAdapter
import com.charlezz.finalarchitecture.ui.base.BaseViewHolder

class RemoteAdapter : BaseAdapter<Post, ViewRemoteBinding, RemoteAdapter.RemoteViewHolder>(diffCallback){
    override fun getLayoutId(): Int = R.layout.view_remote

    inner class RemoteViewHolder(binding: ViewRemoteBinding) : BaseViewHolder<ViewRemoteBinding>(binding)

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