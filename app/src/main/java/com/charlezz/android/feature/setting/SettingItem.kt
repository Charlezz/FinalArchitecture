package com.charlezz.android.feature.setting

import android.content.Context
import com.charlezz.android.BR
import com.charlezz.android.R

class SettingItem constructor(
        val menu: SettingMenu,
        val onItemClickListener: OnItemClickListener
) : BaseSettingItem() {

    override fun getViewType(): Int {
        return R.layout.view_setting_item
    }

    override fun getBindingResId() = BR.item

    fun getTitle(context: Context): String {
        return context.getString(menu.titleResId)
    }

    interface OnItemClickListener {
        fun onSettingItemClick(menu:SettingMenu)
    }

}