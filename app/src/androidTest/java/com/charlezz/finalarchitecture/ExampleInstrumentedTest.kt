package com.charlezz.finalarchitecture

import android.provider.MediaStore
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import com.charlezz.finalarchitecture.data.photo.Photo
import com.charlezz.finalarchitecture.feature.TAG
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.charlezz.finalarchitecture", appContext.packageName)
    }

    @Test
    fun pagingSpeedTest(){

        val context = InstrumentationRegistry.getTargetContext()

        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = null
        val selection = null
        val selectionArgs = null
        val sortOrder = null
        val startTime = System.currentTimeMillis()
        val cursor = context.contentResolver.query(uri, projection, selection, selectionArgs, sortOrder)
        Log.e(TAG,"size = ${cursor.count}")

        var tempTime = System.currentTimeMillis()-startTime
        Log.e(TAG,"retrieve Cursor = ${tempTime}")

        val list = ArrayList<Photo>()
        while (cursor.moveToNext()) {
            val name = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DISPLAY_NAME))
            val path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA))
            list.add(Photo(name,path))
        }

        tempTime = System.currentTimeMillis()-startTime-tempTime
        Log.e(TAG,"make list = ${tempTime}")
        cursor.close()
    }
}