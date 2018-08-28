package com.charlezz.finalarchitecture.feature.local

import android.support.v7.util.DiffUtil
import com.charlezz.finalarchitecture.BR
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.data.local.Person
import com.charlezz.finalarchitecture.databinding.ViewPersonBinding
import com.charlezz.finalarchitecture.feature.base.BaseAdapter
import com.charlezz.finalarchitecture.feature.base.BaseViewHolder


class PersonAdapter : BaseAdapter<Person, ViewPersonBinding, PersonAdapter.PersonViewHolder>(BR.data,diffCallback) {

    override fun getViewHolderLayoutId(): Int = R.layout.view_person

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Person>() {
            override fun areContentsTheSame(oldItem: Person?, newItem: Person?): Boolean {
                return if (oldItem != null && newItem != null){
                    oldItem.id == newItem.id &&
                            oldItem.birth == newItem.birth &&
                            oldItem.name == newItem.name
                } else {
                    false
                }
            }

            override fun areItemsTheSame(oldItem: Person?, newItem: Person?): Boolean {
                return oldItem == newItem
            }
        }
    }
    inner class PersonViewHolder(binding: ViewPersonBinding) : BaseViewHolder<ViewPersonBinding>(binding)
}

