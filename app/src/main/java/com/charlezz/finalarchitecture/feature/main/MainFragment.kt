package com.charlezz.finalarchitecture.feature.main

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.charlezz.finalarchitecture.databinding.FragmentMainBinding
import com.charlezz.finalarchitecture.feature.local.PersonActivity
import com.charlezz.finalarchitecture.feature.photo.PhotoActivity
import com.charlezz.finalarchitecture.feature.pref.PrefActivity
import com.charlezz.finalarchitecture.feature.remote.PostActivity
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainFragment : DaggerFragment() {
    @Inject
    lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var viewmodel: MainFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = binding.root
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel
        viewmodel.clickEvent.observe(this, Observer {
            when(it){
                MainMenu.PERSON_ACTIVITY-> startActivity(Intent(activity, PersonActivity::class.java))
                MainMenu.POST_ACTIVITY->startActivity(Intent(activity, PostActivity::class.java))
                MainMenu.PREFERENCE_ACTIVITY-> startActivity(Intent(activity, PrefActivity::class.java))
                MainMenu.PHOTO_ACTIVITY->startActivity(Intent(activity, PhotoActivity::class.java))
            }
        })
    }
}