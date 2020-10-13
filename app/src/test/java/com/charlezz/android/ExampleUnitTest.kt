package com.charlezz.android

import android.graphics.Bitmap
import androidx.collection.LruCache
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
private const val FAKE_STRING = "HELLO WORLD"

@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {

    val list = ArrayList<Int>()


    @Test
    fun example1(){
        val cache = LruCache<String,Int>( 5)

        cache.put("A",0) //[A]
        cache.put("B",0) //[A, B]
        cache.put("C",0) //[A, B, C]
        cache.put("D",0) //[A, B, C, D]
        cache.put("E",0) //[A, B, C, D, E]
        println(cache.snapshot().keys.toList())
        cache.put("F",0) //[B, C, D, E, F]
        println(cache.snapshot().keys.toList())
        cache.put("D",0) //[B, C, E, F, D]
        println(cache.snapshot().keys.toList())
        cache.get("C") //[B, E, F, D, C]
        println(cache.snapshot().keys.toList())

    }

    fun arrange(){

    }



}
