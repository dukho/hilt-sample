package com.example.info

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.base.logger.Logger
import com.example.info.helper.InfoHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class InfoActivity : AppCompatActivity() {
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var logger: Logger

    @Inject
    lateinit var helper: InfoHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        Log.d("HiltTutorialLogTag","Info activity| sharedPreferences  = $sharedPreferences")
        Log.d("HiltTutorialLogTag","Info activity| logger             = $logger")
        Log.d("HiltTutorialLogTag","Info activity| helper             = $helper")
        logger.log("Logging from the Info Activity")
        helper.dumpInfo("Dump from info activity")
    }
}