package com.example.httpjsonparser
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.random.Random

private const val NEW_UPLOADED_SONGS = "NEW_UPLOADED_SONGS"

class SongNotificationManager (
    private val context: Context) {
    private val notificationManager = NotificationManagerCompat.from(context)
    //private val SongDataProvider.getAllSongs().random()

    init {
        initNotificationChannels()
    }

    fun publishNewSongNotification() {
        val intent = Intent(context, SongDetailActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra(SONG_INFO_KEY, "This string is coming from the notification")
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        var builder = NotificationCompat.Builder(context, NEW_UPLOADED_SONGS)
                .setSmallIcon( R.drawable.ic_songnote)
                .setContentTitle("just released a new song!!!")
                .setContentText("Listen to now on Dotify")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(notificationManager) {
            val notificationID = Random.nextInt()
            notify(notificationID, builder.build())
        }
    }

    private fun initNotificationChannels(){
        initNewSongChannel()
        //initPromotionalChannel()
    }

    private fun initNewSongChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = context.getString(R.string.new_songs)
            val descriptionText = context.getString(R.string.new_songs_channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(NEW_UPLOADED_SONGS, name, importance).apply {
                description = descriptionText
            }

            notificationManager.createNotificationChannel(channel)
        }
    }

    //private fun initPromotionalChannel() {

   // }

}
