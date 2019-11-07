package com.charlezz.finalarchitecture

import com.charlezz.finalarchitecture.feature.local.UserDao
import com.charlezz.finalarchitecture.feature.pref.PreferencesHelper
import com.charlezz.finalarchitecture.feature.remote.ApiHelper
import com.charlezz.finalarchitecture.feature.local.UserViewModel
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
    lateinit var DBHelper: DBHelper

    lateinit var personViewModel: UserViewModel

    @Mock
    lateinit var personDao: UserDao

    @Mock
    lateinit var preferencesHelper: PreferencesHelper

    @Mock
    lateinit var apiHelper: ApiHelper

    @Before fun init(){
    }

    @Test
    fun personViewModel(){
        DBHelper.getPersons()
    }
}
