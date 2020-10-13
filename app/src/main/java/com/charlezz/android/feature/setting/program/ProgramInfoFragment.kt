package com.charlezz.android.feature.setting.program

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.charlezz.android.R
import com.charlezz.android.databinding.FragmentProgramInfoBinding
import com.charlezz.android.feature.OptionMenuViewModel
import com.charlezz.android.feature.ToolbarViewModel
import com.charlezz.android.feature.setting.SettingViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProgramInfoFragment : Fragment() {

    @Inject
    lateinit var toolbarViewModel: ToolbarViewModel

    @Inject
    lateinit var optionMenuViewModel: OptionMenuViewModel

    lateinit var binding: FragmentProgramInfoBinding

    private val viewModel: ProgramInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        optionMenuViewModel.setMenuRes(null)
        toolbarViewModel.setDefaulNavIcon()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_program_info, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }
}