package com.example.workmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

const val CHANNEL_ID = "CHANNEL_ID"

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        createNotificationChannel(this)
//        val btn = findViewById<Button>(R.id.btn)
//        btn.setOnClickListener {
//            notifyMessage(this)
//        }
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
      
        val notifyWorkRequest = OneTimeWorkRequestBuilder<NotifyWorker>()
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance().enqueue(notifyWorkRequest)

    }



}