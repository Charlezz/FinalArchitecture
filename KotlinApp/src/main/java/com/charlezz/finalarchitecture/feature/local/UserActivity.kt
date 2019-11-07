package com.charlezz.finalarchitecture.feature.local

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.charlezz.finalarchitecture.databinding.ActivityUserBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class UserActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var binding: ActivityUserBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: UserViewModel by viewModels{
        viewModelFactory
    }

    @Inject
    lateinit var adapter:UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.recyclerView.adapter = adapter
        binding.viewmodel = viewModel
    }

}
