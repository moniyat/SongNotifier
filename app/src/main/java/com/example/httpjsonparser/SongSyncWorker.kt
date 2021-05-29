package com.example.httpjsonparser

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class SongSyncWorker(
    private val context: Context,
    workerParameters: WorkerParameters
): CoroutineWorker(context, workerParameters) {

    private val application by lazy { context.applicationContext as httpparser }
    //private val songNotificationManager by lazy { application.SongNotificationManager }

    override suspend fun doWork(): Result {

        Log.i("SongSyncWorker", "syncing the songs now")
        //SongNotificationManager.publishNewSongNotification()


        return Result.success()
    }
}

