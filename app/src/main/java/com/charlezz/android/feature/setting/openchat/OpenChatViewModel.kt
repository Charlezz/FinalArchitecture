package com.charlezz.android.feature.setting.openchat

import androidx.lifecycle.ViewModel
import com.charlezz.android.core.SingleLiveEvent

class OpenChatViewModel : ViewModel() {

    val openChatClickEvent:SingleLiveEvent<Unit> = SingleLiveEvent<Unit>()

    fun goToOpenChat(){
        openChatClickEvent.call()
    }

}