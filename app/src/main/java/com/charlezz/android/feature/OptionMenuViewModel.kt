package com.charlezz.android.feature

import android.app.Application
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.charlezz.android.R
import com.charlezz.android.core.SingleLiveEvent

class OptionMenuViewModel
@ViewModelInject constructor(
        private val app: Application,
        private @Assisted val savedStateHandle: SavedStateHandle
) : AndroidViewModel(app) {

    companion object {
        private const val KEY_MENU_RES = "menuRes"
    }

    val menuRes: LiveData<Int?> = savedStateHandle.getLiveData(KEY_MENU_RES)
    val optionMenuClickEvent = SingleLiveEvent<MenuItem>()

    fun setMenuRes(menuRes: Int?) {
        savedStateHandle.set(KEY_MENU_RES, menuRes)
    }

    fun onCreateOptionMenu(menu: Menu?): Boolean {
        if (menuRes.value != null && menu != null) {
            MenuInflater(app).inflate(menuRes.value!!, menu)
            return true
        }
        return false
    }

    fun onOptionsItemSelected(item: MenuItem): Boolean {
        optionMenuClickEvent.value = item
        return true
    }
}
