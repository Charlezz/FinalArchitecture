package com.charlezz.finalarchitecture.feature.local

import androidx.annotation.NonNull
import androidx.recyclerview.widget.DiffUtil
import com.charlezz.finalarchitecture.BR
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.ViewUserBinding
import com.charlezz.finalarchitecture.feature.base.BaseAdapter
import com.charlezz.finalarchitecture.feature.base.BaseViewHolder
import javax.inject.Inject

class UserAdapter @Inject constructor(): BaseAdapter<User, ViewUserBinding, UserAdapter.PersonViewHolder>(BR.data,diffCallback) {

    override fun getViewHolderLayoutId(): Int = R.layout.view_user

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<User>() {
            override fun areContentsTheSame(@NonNull oldItem: User, @NonNull newItem: User): Boolean {
                return oldItem.id == newItem.id &&
                            oldItem.birth == newItem.birth &&
                            oldItem.name == newItem.name
            }

            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }
        }
    }
    inner class PersonViewHolder(binding: ViewUserBinding) : BaseViewHolder<ViewUserBinding>(binding)
}

