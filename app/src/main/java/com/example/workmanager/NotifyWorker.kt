package com.example.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters


class NotifyWorker(val appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {
    override fun doWork(): Result {
        createNotificationChannel(appContext)
        notifyMessage(appContext)
        return Result.success()
    }


}
