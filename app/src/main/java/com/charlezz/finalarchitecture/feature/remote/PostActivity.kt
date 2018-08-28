package com.charlezz.finalarchitecture.feature.remote

import android.os.Bundle
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.ActivityPostBinding
import com.charlezz.finalarchitecture.extension.replaceFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class PostActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var binding: ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState==null){
            replaceFragment(R.id.container, PostFragment())
        }
    }
}
