package com.example.httpjsonparser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.httpjsonparser.databinding.ActivitySongDetailBinding

const val SONG_INFO_KEY = "SONG_INFO_KEY"

class SongDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySongDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongDetailBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {
            songInfo.text = intent.getStringExtra(SONG_INFO_KEY)

        }
    }
}

