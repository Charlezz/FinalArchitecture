package com.charlezz.android.feature

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.charlezz.android.R
import com.charlezz.android.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private val optionMenuViewModel:OptionMenuViewModel by viewModels()

    private val toolbarViewModel: ToolbarViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        binding.lifecycleOwner = this
        binding.toolbarViewModel = toolbarViewModel
        optionMenuViewModel.menuRes.observe(this){
            invalidateOptionsMenu()
        }
        toolbarViewModel.navClickEvent.observe(this){
            val navController =binding.navHostFragment.findNavController()
            if(navController.currentDestination?.id == R.id.postFragment){
                // nothing to do
            }else{
                navController.popBackStack()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return optionMenuViewModel.onCreateOptionMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return optionMenuViewModel.onOptionsItemSelected(item)
    }
}
