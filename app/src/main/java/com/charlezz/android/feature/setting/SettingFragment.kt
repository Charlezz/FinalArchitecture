package com.charlezz.android.feature.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.charlezz.android.R
import com.charlezz.android.core.recyclerview.DividerItemDecoration
import com.charlezz.android.feature.ToolbarViewModel
import com.charlezz.android.databinding.FragmentSettingBinding
import com.charlezz.android.feature.OptionMenuViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class SettingFragment :Fragment(){

    @Inject
    lateinit var toolbarViewModel: ToolbarViewModel

    @Inject
    lateinit var optionMenuViewModel: OptionMenuViewModel

    @Inject
    lateinit var adapter:SettingAdapter

    @Inject
    lateinit var linearLayoutManager:Provider<LinearLayoutManager>

    @Inject
    lateinit var dividerItemDecoration: DividerItemDecoration

    lateinit var binding : FragmentSettingBinding

    private val viewModel: SettingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.load()
        toolbarViewModel.setNavIconRes(R.drawable.arrow_back_24px, R.color.white)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_setting, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        optionMenuViewModel.setMenuRes(null)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = linearLayoutManager.get()
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
        viewModel.items.observe(viewLifecycleOwner){ adapter.setItems(it) }

        viewModel.menuClickEvent.observe(viewLifecycleOwner){
            findNavController().navigate(it.navDirections)
        }
    }
}