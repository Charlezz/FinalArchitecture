package com.charlezz.android.feature.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
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
import com.charlezz.android.databinding.FragmentPostDetailBinding
import com.charlezz.android.db.entity.Post
import com.charlezz.android.feature.OptionMenuViewModel
import com.charlezz.android.feature.ToolbarViewModel
import com.charlezz.android.feature.post.PostDialog
import com.charlezz.android.feature.post.PostDialog.SimpleListener
import com.charlezz.htmltextview.LocalLinkMovementMethod
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PostDetailFragment : Fragment() {

    @Inject
    lateinit var toolbarViewModel: ToolbarViewModel

    @Inject
    lateinit var optionMenuViewModel: OptionMenuViewModel

    private val viewModel: PostDetailViewModel by viewModels()

    private val binding: FragmentPostDetailBinding by lazy {
        DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.fragment_post_detail, null, false)
    }

    private val navController: NavController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        optionMenuViewModel.setMenuRes(null)
        toolbarViewModel.setVisible(false)
        if (savedInstanceState == null) {
            arguments?.getParcelable<Post>("post")?.let {
                viewModel.load(it)
            } ?: throw IllegalArgumentException()
        }

    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.content.movementMethod = LocalLinkMovementMethod.getInstance()
        viewModel.backEvent.observe(viewLifecycleOwner) { navController.navigateUp() }
        viewModel.optionMenuEvent.observe(viewLifecycleOwner) {
            showOptionsDialog()
        }
    }

    private fun showOptionsDialog(){
        PostDialog(SimpleListener(this, viewModel.url.value)).show(childFragmentManager)

    }

}