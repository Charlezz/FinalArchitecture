package com.charlezz.finalarchitecture.feature.local

import androidx.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.ActivityUserBinding
import com.charlezz.finalarchitecture.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @Provides
    @ActivityScope
    fun provideActivityPersonBinding(activity: UserActivity): ActivityUserBinding =
            DataBindingUtil.setContentView(activity, R.layout.activity_user)


}