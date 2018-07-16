package com.charlezz.finalarchitecture.ui.local

import android.support.v7.util.DiffUtil
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.data.local.entity.Person
import com.charlezz.finalarchitecture.databinding.ViewPersonBinding
import com.charlezz.finalarchitecture.ui.BaseAdapter
import com.charlezz.finalarchitecture.ui.BaseViewHolder


class PersonAdapter : BaseAdapter<Person, ViewPersonBinding, PersonAdapter.PersonViewHolder>(diffCallback) {

    override fun getLayoutId(): Int = R.layout.view_person

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Person>() {
            override fun areContentsTheSame(oldItem: Person?, newItem: Person?): Boolean {
                return if (oldItem != null && newItem != null) oldItem.id == newItem.id &&
                        oldItem.birth == newItem.birth &&
                        oldItem.name == newItem.name else {
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

