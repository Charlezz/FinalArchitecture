package com.charlezz.android.feature.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.charlezz.android.R
import com.charlezz.android.feature.ToolbarViewModel
import com.charlezz.android.databinding.FragmentPostBinding
import com.charlezz.android.db.AppDatabase
import com.charlezz.android.feature.OptionMenuViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class PostFragment : Fragment() {

    @Inject
    lateinit var adapter: PostPagingAdapter

    @Inject
    lateinit var db: AppDatabase

    @Inject
    lateinit var toolbarViewModel: ToolbarViewModel

    @Inject
    lateinit var optionMenuViewModel: OptionMenuViewModel

    private val viewModel :PostViewModel by viewModels()

    private val binding: FragmentPostBinding by lazy{
        DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.fragment_post, null, false)
    }

    private val navController:NavController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            @OptIn(ExperimentalCoroutinesApi::class)
            viewModel.posts.collectLatest {
                adapter.submitData(it)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        optionMenuViewModel.setMenuRes(R.menu.post_menu)
        toolbarViewModel.setVisible(true).setNavIconRes(R.drawable.toolbar_icon)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.postClickEvent.observe(viewLifecycleOwner){
            navController.navigate(R.id.action_post_to_postDetailFragment, Bundle().apply { putParcelable("post",it.post) } )
        }

        viewModel.postLongClickEvent.observe(viewLifecycleOwner){
            PostDialog(PostDialog.SimpleListener(this, it.post.link)).show(childFragmentManager)
        }

        optionMenuViewModel.optionMenuClickEvent.observe(viewLifecycleOwner){
            when(it.itemId){
                R.id.menu_setting->navController.navigate(R.id.action_post_to_setting)
            }
        }
    }

}