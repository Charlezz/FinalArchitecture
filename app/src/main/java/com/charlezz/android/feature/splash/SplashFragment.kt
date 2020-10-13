package com.charlezz.android.feature.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.charlezz.android.R
import com.charlezz.android.feature.ToolbarViewModel
import com.charlezz.android.databinding.FragmentSplashBinding
import com.charlezz.android.feature.OptionMenuViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : Fragment() {

    @Inject
    lateinit var toolbarViewModel: ToolbarViewModel

    @Inject
    lateinit var optionMenuViewModel : OptionMenuViewModel

    private lateinit var binding: FragmentSplashBinding

    private val navController: NavController by lazy { findNavController() }

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initialize()
        optionMenuViewModel.setMenuRes(null)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.initializeEvent.observe(viewLifecycleOwner) {
            navController.navigate(SplashFragmentDirections.actionSplashFragmentToPost())
        }
        toolbarViewModel.setVisible(false)
    }

}