package com.example.hilttutorial.database

import android.util.Log
import javax.inject.Inject

const val TAG = "HiltTutorialLogTag"

open class DatabaseService @Inject constructor() {
    fun log(message: String) {
        Log.d(TAG, "Database service message: $message")
    }
}