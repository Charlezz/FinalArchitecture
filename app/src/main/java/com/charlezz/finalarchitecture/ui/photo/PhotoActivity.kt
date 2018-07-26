package com.charlezz.finalarchitecture.ui.photo

import android.os.Bundle
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.ActivityPhotoBinding
import com.charlezz.finalarchitecture.extension.replaceFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class PhotoActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var binding: ActivityPhotoBinding

    @Inject
    lateinit var viewModel:PhotoActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState==null){
            replaceFragment(R.id.container, PhotoFragment())
        }
    }
}
