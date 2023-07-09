package com.example.hilttutorial.database

import android.content.Context
import com.example.hilttutorial.android.util.Log
//import android.util.Log
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class DatabaseAdapter @Inject constructor(
    @ActivityContext private val context: Context,
    private val databaseService: DatabaseService
) {
    fun log(message: String) {
        Log.d(TAG, "DatabaseAdapter: $message - $this")
        databaseService.log(message)
        Log.d(TAG, "context available: $context")
    }
}