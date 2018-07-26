package com.charlezz.finalarchitecture.data

import com.charlezz.finalarchitecture.data.local.DBHelper
import com.charlezz.finalarchitecture.data.pref.PreferencesHelper
import com.charlezz.finalarchitecture.data.remote.ApiHelper

interface DataManager : ApiHelper, DBHelper, PreferencesHelper