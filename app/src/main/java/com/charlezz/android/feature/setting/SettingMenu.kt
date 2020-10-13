package com.charlezz.android.feature.setting

import androidx.annotation.StringRes
import androidx.navigation.NavDirections
import com.charlezz.android.R

enum class SettingMenu constructor(@StringRes val titleResId:Int, val navDirections: NavDirections){
    PROGRAM_VERSION(R.string.setting_program_info,SettingFragmentDirections.actionSettingFragmentToProgramInfoFragment()),
    KAKAO_OPENCHAT(R.string.open_chat,SettingFragmentDirections.actionSettingFragmentToOpenChatFragment())
}