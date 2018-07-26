package com.charlezz.finalarchitecture.ui.photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.charlezz.finalarchitecture.databinding.FragmentPhotoBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PhotoFragment:DaggerFragment(){
    @Inject
    lateinit var binding:FragmentPhotoBinding

    @Inject
    lateinit var viewModel:PhotoFragmentViewModel

    @Inject
    lateinit var adapter:PhotoAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)= binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setLifecycleOwner(this)
        binding.recyclerView.adapter = adapter
        binding.viewModel = viewModel
    }

}