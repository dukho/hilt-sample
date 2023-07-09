package com.example.hilttutorial

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.hilttutorial.database.DatabaseAdapter
import com.example.hilttutorial.database.DatabaseService
import com.example.hilttutorial.database.TAG
import com.example.hilttutorial.hilt.CallInterceptor
import com.example.hilttutorial.network.NetworkAdapter
import com.example.hilttutorial.network.NetworkService
import com.example.hilttutorial.stats.StatsViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var databaseAdapter: DatabaseAdapter

    @Inject
    lateinit var networkAdapter: NetworkAdapter

    @CallInterceptor
    @Inject
    lateinit var networkService: NetworkService

    private val statsViewModel: StatsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseAdapter.log("Hey, hilt!!")

        networkAdapter.log("Interface binding")

        networkService.performNetworkcall()

        statsViewModel.statsLiveData.observe(
            this
        ) {
            stats -> Log.d(TAG, "New state coming int: $stats")
        }
        //statsViewModel.startStatCollection()

        Log.d(TAG,"First activity| databaseAdapter = $databaseAdapter")
        Log.d(TAG,"First activity| networkAdapter  = $networkAdapter")
        Log.d(TAG,"First activity| networkService  = $networkService")
    }

    override fun onResume() {
        super.onResume()
        startActivity(Intent(this, SecondActivity::class.java))
    }

    @Inject
    fun directToDatabase(databaseService: DatabaseService) {
        databaseService.log("Method injection!")
    }
}