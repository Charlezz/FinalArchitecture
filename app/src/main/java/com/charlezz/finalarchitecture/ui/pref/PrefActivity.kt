package com.charlezz.finalarchitecture.ui.pref

import android.os.Bundle
import com.charlezz.finalarchitecture.databinding.ActivityPrefBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class PrefActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var binding: ActivityPrefBinding

    @Inject
    lateinit var viewmodel:PrefViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewmodel = viewmodel
        binding.setLifecycleOwner(this)
        binding.save.setOnClickListener {
            viewmodel.setData(binding.editText.text.toString())
        }
    }
}
