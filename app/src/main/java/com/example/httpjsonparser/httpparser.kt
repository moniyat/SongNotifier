package com.example.httpjsonparser

import android.app.Application

class httpparser: Application() {

    lateinit var SongData: songData
   // lateinit var songSyncWorker: SongSyncWorker

    override fun onCreate() {
        super.onCreate()

        SongData = songData()
    }
}
