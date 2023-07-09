package com.example.base.di

import com.example.base.logger.Logger
import com.example.base.logger.LoggerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface BaseLoggerModule {
    @Singleton
    @Binds
    fun bindLogger(loggerImpl: LoggerImpl): Logger

}