package com.charlezz.android.feature.setting.openchat

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.charlezz.android.databinding.FragmentOpenChatBinding
import com.charlezz.android.feature.setting.SettingViewModel

class OpenChatFragment :Fragment(){

    lateinit var binding:FragmentOpenChatBinding

    private val viewModel: OpenChatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.binding = FragmentOpenChatBinding.inflate(inflater, container, false)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.openChatClickEvent.observe(viewLifecycleOwner){
            startActivity(
                    Intent().apply {
                        action = Intent.ACTION_VIEW
                        data = Uri.parse("https://open.kakao.com/o/gRToxkub")
                    }
            )
        }
    }
}