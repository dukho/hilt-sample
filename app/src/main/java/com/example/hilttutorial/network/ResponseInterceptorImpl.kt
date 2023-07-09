package com.example.hilttutorial.network

import android.util.Log
import com.example.hilttutorial.database.TAG
import javax.inject.Inject

class ResponseInterceptorImpl @Inject constructor() : Interceptor {
    override fun log(message: String) {
        Log.d(TAG, "This is response interceptor: $message")
    }
}