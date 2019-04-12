package com.charlezz.finalarchitecture

import android.content.Context
import java.io.File

object AppConstants {

    val DB_NAME = "mindorks_mvvm.db"

    val PREF_NAME = "mindorks_pref"

    val MAX_DECK_COUNT = 3

    val DEFAULT_DECK_NAME = "Default"

    val KEY_CARD_VERSION = "cards_version"

    val KEY_OLD_VERSION = "KEY_OLD_VERSION"
    val KEY_NEW_VERSION = "KEY_NEW_VERSION"
    val KEY_WORK_NEXT = "KEY_WORK_NEXT"

    fun getCardsFile(context: Context): File {
        return File(context.filesDir, "ui/cards").apply {
            if (!exists()) {
                mkdirs()
            }
        }
    }
}