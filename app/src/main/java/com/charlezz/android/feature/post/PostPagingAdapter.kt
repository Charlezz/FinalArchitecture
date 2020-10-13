package com.charlezz.android.feature.post

import androidx.recyclerview.widget.DiffUtil
import com.charlezz.android.BR
import com.charlezz.android.core.recyclerview.BasePagingAdapter
import com.charlezz.android.core.recyclerview.BaseViewHolder
import com.charlezz.android.databinding.ViewPostItemBinding
import javax.inject.Inject

class PostPagingAdapter @Inject constructor() : BasePagingAdapter<PostItem, BaseViewHolder<ViewPostItemBinding>>(BR.viewModel, POST_COMPARATOR) {

    companion object {
        val POST_COMPARATOR = object : DiffUtil.ItemCallback<PostItem>() {
            override fun areContentsTheSame(oldItem: PostItem, newItem: PostItem): Boolean =
                    oldItem.post == newItem.post && oldItem.post.id == newItem.post.id

            override fun areItemsTheSame(oldItem: PostItem, newItem: PostItem): Boolean =
                    oldItem.post.date == newItem.post.date
        }
    }

}