package com.example.info.di

import com.example.info.helper.InfoHelper
import com.example.info.helper.InfoHelperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
interface HelperModule {
    @Binds
    fun bindHelper(helper: InfoHelperImpl): InfoHelper
}