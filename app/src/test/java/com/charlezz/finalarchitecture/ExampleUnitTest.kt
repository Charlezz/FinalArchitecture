package com.charlezz.finalarchitecture

import com.charlezz.finalarchitecture.data.DataManager
import com.charlezz.finalarchitecture.data.local.DBHelper
import com.charlezz.finalarchitecture.data.pref.PreferencesHelper
import com.charlezz.finalarchitecture.data.remote.ApiHelper
import com.charlezz.finalarchitecture.feature.local.PersonFragmentViewModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
private const val FAKE_STRING = "HELLO WORLD"

@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {

    @Mock
    lateinit var dataManager: DataManager

    lateinit var personViewModel: PersonFragmentViewModel

    @Mock
    lateinit var dbHelper:DBHelper

    @Mock
    lateinit var preferencesHelper:PreferencesHelper

    @Mock
    lateinit var apiHelper:ApiHelper

    @Before fun init(){
    }

    @Test
    fun personViewModel(){
        dataManager.getPersons()
    }
}
