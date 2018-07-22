package com.charlezz.finalarchitecture.ui.remote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.charlezz.finalarchitecture.databinding.FragmentRemoteBinding
import com.charlezz.finalarchitecture.viewmodel.RemoteFragmentViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class RemoteFragment : DaggerFragment() {
    @Inject
    lateinit var binding: FragmentRemoteBinding

    @Inject
    lateinit var viewmodel: RemoteFragmentViewModel

    @Inject
    lateinit var adapter: RemoteAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setLifecycleOwner(this)
        binding.viewmodel = viewmodel
        binding.recyclerView.adapter = adapter
    }

}