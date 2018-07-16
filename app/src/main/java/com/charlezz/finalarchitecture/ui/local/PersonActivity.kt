package com.charlezz.finalarchitecture.ui.local

import android.os.Bundle
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.ActivityPersonBinding
import com.charlezz.finalarchitecture.extension.replaceFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class PersonActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var binding: ActivityPersonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState==null){
            replaceFragment(R.id.container, PersonFragment())
        }
    }
}
