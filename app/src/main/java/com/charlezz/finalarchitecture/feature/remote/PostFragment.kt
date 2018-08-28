package com.charlezz.finalarchitecture.feature.remote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.charlezz.finalarchitecture.databinding.FragmentPostBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PostFragment : DaggerFragment() {
    @Inject
    lateinit var binding: FragmentPostBinding

    @Inject
    lateinit var viewmodel: PostFragmentViewModel

    @Inject
    lateinit var adapter: PostAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setLifecycleOwner(this)
        binding.recyclerView.adapter = adapter
        binding.viewmodel = viewmodel

    }

}