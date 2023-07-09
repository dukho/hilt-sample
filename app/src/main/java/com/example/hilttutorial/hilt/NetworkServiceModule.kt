package com.example.hilttutorial.hilt

import android.content.Context
import android.util.Log
import com.example.hilttutorial.database.TAG
import com.example.hilttutorial.network.CallInterceptorImpl
import com.example.hilttutorial.network.NetworkService
import com.example.hilttutorial.network.ResponseInterceptorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class NetworkServiceModule {
    @ActivityScoped
    @NoInterceptor
    @Provides
    fun provideNetworkService(): NetworkService {
        return NetworkService.Builder()
            .host("google.com")
            .protocol("HTTPS")
            .build()
    }

    @ActivityScoped
    @CallInterceptor
    @Provides
    fun provideCallNetworkService(@ApplicationContext context: Context): NetworkService {
        Log.d(TAG,"provideCallNetworkService got application context: $context")

        return NetworkService.Builder()
            .host("google.com")
            .protocol("HTTPS")
            .interceptor(CallInterceptorImpl())
            .build()
    }

    @ActivityScoped
    @ResponseInterceptor
    @Provides
    fun provideResponseNetworkService(): NetworkService {
        return NetworkService.Builder()
            .host("google.com")
            .protocol("HTTPS")
            .interceptor(ResponseInterceptorImpl())
            .build()
    }
}