package com.charlezz.android.feature.setting

import android.app.Application
import android.os.Bundle
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.charlezz.android.BuildConfig
import com.charlezz.android.R
import com.charlezz.android.core.SingleLiveEvent

class SettingViewModel @ViewModelInject constructor(
        private val app: Application
) : AndroidViewModel(app), SettingItem.OnItemClickListener {

    val items: MutableLiveData<List<BaseSettingItem>> = MutableLiveData()

    val menuClickEvent = SingleLiveEvent<SettingMenu>()

    fun load(){
        val items = ArrayList<BaseSettingItem>()
        items.add(SettingItem(SettingMenu.PROGRAM_VERSION, this))
        items.add(SettingItem(SettingMenu.KAKAO_OPENCHAT, this))
        this.items.value = items
   }

    override fun onSettingItemClick(menu: SettingMenu) {
        menuClickEvent.value = menu
    }

}