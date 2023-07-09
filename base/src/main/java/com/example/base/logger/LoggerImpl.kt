package com.example.base.logger

import android.content.Context
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LoggerImpl @Inject constructor(
    @ApplicationContext
    private val context: Context
) : Logger {
    override fun log(message: String) {
        Log.d(TAG, message)
    }

    companion object {
        const val TAG = "HiltTutorialLogTag"
    }
}