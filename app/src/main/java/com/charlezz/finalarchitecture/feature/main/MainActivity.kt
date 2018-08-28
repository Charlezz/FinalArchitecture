package com.charlezz.finalarchitecture.feature.main

import android.os.Bundle
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.ActivityMainBinding
import com.charlezz.finalarchitecture.extension.replaceFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState==null){
            replaceFragment(R.id.container, MainFragment())
        }
    }
}
