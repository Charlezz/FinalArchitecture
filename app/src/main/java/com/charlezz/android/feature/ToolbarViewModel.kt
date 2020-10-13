package com.charlezz.android.feature

import android.app.Application
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.IconMarginSpan
import android.text.style.ImageSpan
import android.view.View
import androidx.core.content.ContextCompat
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.charlezz.android.R
import com.charlezz.android.core.SingleLiveEvent
import com.charlezz.android.generated.callback.OnClickListener

class ToolbarViewModel
@ViewModelInject constructor(
        private val app: Application,
        @Assisted private val savedStateHandle: SavedStateHandle
) : AndroidViewModel(app), View.OnClickListener {

    companion object {
        private const val KEY_TITLE = "title"
        private const val KEY_TITLE_COLOR = "titleColor"
        private const val KEY_BACKGROUND_COLOR = "backgroundColor"
        private const val KEY_VISIBLE = "visible"
        private const val KEY_NAV_ICON_RES = "navIconRes"
        private const val KEY_NAV_ICON_TINT = "navIconTint"
    }

    var title: LiveData<CharSequence> = savedStateHandle.getLiveData(KEY_TITLE, app.getString(R.string.app_name))
    var titleColor: LiveData<Int> = savedStateHandle.getLiveData(KEY_TITLE_COLOR, ContextCompat.getColor(app, R.color.white))
    var backgroundColor: LiveData<Int> = savedStateHandle.getLiveData(KEY_BACKGROUND_COLOR, ContextCompat.getColor(app, R.color.colorPrimaryDark))
    var visible: LiveData<Boolean> = savedStateHandle.getLiveData(KEY_VISIBLE, true)
    var navIconRes: LiveData<Int> = savedStateHandle.getLiveData(KEY_NAV_ICON_RES, R.drawable.toolbar_icon)
    var navIconTint: LiveData<Int?> = savedStateHandle.getLiveData(KEY_NAV_ICON_TINT)

    val navClickEvent = SingleLiveEvent<Unit>()


    fun setTitle(charSequence: CharSequence): ToolbarViewModel {
        savedStateHandle.set(KEY_TITLE, charSequence)
        return this
    }

    fun setTitleColor(color: Int): ToolbarViewModel {
        savedStateHandle.set(KEY_TITLE_COLOR, color)
        return this
    }

    fun setBackgroundColor(color: Int): ToolbarViewModel {
        savedStateHandle.set(KEY_BACKGROUND_COLOR, color)
        return this
    }

    fun setVisible(visible: Boolean): ToolbarViewModel {
        savedStateHandle.set(KEY_VISIBLE, visible)
        return this
    }

    fun setNavIconRes(iconRes: Int, tintColor: Int? = null): ToolbarViewModel {
        savedStateHandle.set(KEY_NAV_ICON_RES, iconRes)
        savedStateHandle.set(KEY_NAV_ICON_TINT, tintColor)
        return this
    }
    fun setDefaulNavIcon(){
        setNavIconRes(R.drawable.arrow_back_24px, R.color.white)
    }

    override fun onClick(view: View?) {
        navClickEvent.call()
    }

}