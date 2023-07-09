package com.example.hilttutorial

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.base.logger.Logger
import com.example.hilttutorial.database.DatabaseAdapter
import com.example.hilttutorial.database.TAG
import com.example.hilttutorial.hilt.CallInterceptor
import com.example.hilttutorial.network.NetworkAdapter
import com.example.hilttutorial.network.NetworkService
import com.example.info.InfoActivity
import com.example.info.helper.InfoHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {
    @Inject
    lateinit var databaseAdapter: DatabaseAdapter

    @Inject
    lateinit var networkAdapter: NetworkAdapter

    @CallInterceptor
    @Inject
    lateinit var networkService: NetworkService

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var logger: Logger

    @Inject
    lateinit var helper: InfoHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d(TAG,"Second activity| databaseAdapter    = $databaseAdapter")
        Log.d(TAG,"Second activity| networkAdapter     = $networkAdapter")
        Log.d(TAG,"Second activity| networkService     = $networkService")

        Log.d(TAG,"Second activity| sharedPreferences  = $sharedPreferences")
        Log.d(TAG,"Second activity| logger             = $logger")
        Log.d(TAG,"Second activity| helper             = $helper")
        logger.log("Logging from the Second Activity")
        helper.dumpInfo("Dump from the Second Activity")
    }

    override fun onResume() {
        super.onResume()
        startActivity(Intent(this, InfoActivity::class.java))
    }
}