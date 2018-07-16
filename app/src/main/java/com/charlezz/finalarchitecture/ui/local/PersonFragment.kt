package com.charlezz.finalarchitecture.ui.local

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.charlezz.finalarchitecture.databinding.FragmentPersonBinding
import com.charlezz.finalarchitecture.viewmodel.PersonFragmentViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PersonFragment : DaggerFragment() {
    @Inject
    lateinit var binding: FragmentPersonBinding

    @Inject
    lateinit var viewmodel: PersonFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setLifecycleOwner(this)
        binding.viewmodel = viewmodel
    }

}