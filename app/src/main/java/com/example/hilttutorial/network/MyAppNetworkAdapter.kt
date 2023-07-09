package com.example.hilttutorial.network

import android.util.Log
import com.example.hilttutorial.database.TAG
import javax.inject.Inject

class MyAppNetworkAdapter @Inject constructor() : NetworkAdapter {
    override fun log(message: String) {
        Log.d(TAG, "MyAppNetworkAdapter: $message")
    }
}