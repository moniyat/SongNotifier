package com.example.httpjsonparser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.httpjsonparser.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import com.example.httpjsonparser.SongNotificationManager
import org.json.JSONObject
import java.net.URL
import java.util.concurrent.TimeUnit
import androidx.work.*



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SongAdapter
    private val httpJsonParser: httpparser by lazy { application as httpparser}
    private val SongData by lazy {httpJsonParser.SongData}
    //private val SongNotificationManager by lazy { httpJsonParser.SongNotificationManager }
    override fun onCreate(savedInstanceState: Bundle?) {
        //val theURL = URL("https://raw.githubusercontent.com/echeeUW/codesnippets/master/musiclibrary.json").readText()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {
            adapter = SongAdapter(listOf())
            rv.adapter = adapter
            button.setOnClickListener {
                lifecycleScope.launch {
                    runCatching {
                        val song = SongData.getSong()
                        val newSong = listOf(song)
                       // adapter.updatePlaylist(List<Song>)
                    }.onFailure {
                        Toast.makeText(this@MainActivity, "Error occurred when fetching your playlist", Toast.LENGTH_SHORT)
                    }
                }
            }

            switchContent.setOnCheckedChangeListener{_, isChecked ->
                if (isChecked) {
                    //val request = PeriodicWorkRequestBuilder<SongSyncWorker>(20, TimeUnit.MINUTES)
                    //SongNotificationManager.publishNewSonglNotification()
                }
            }

            suspend fun loadImg(){
                with(binding) {
                    album.load(SongData.getSong().smallImgURL)
                }
            }

        }
    }
}