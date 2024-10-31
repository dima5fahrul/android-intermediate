package com.example.androidintermediate.media.media_player

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidintermediate.R
import okio.IOException

class MediaPlayerActivity : AppCompatActivity() {
    private var mMediaPlayer: MediaPlayer? = null
    private var isReady: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_media_player)

        compatView()

        val btnPlay = findViewById<Button>(R.id.btn_play)
        val btnStop = findViewById<Button>(R.id.btn_stop)
        btnPlay.setOnClickListener {
            if (!isReady) {
                mMediaPlayer?.prepareAsync()
            } else {
                if (mMediaPlayer?.isPlaying is Boolean) {
                    mMediaPlayer?.pause()
                } else {
                    mMediaPlayer?.start()
                }
            }
        }

        btnStop.setOnClickListener {
            if (mMediaPlayer?.isPlaying as Boolean || isReady) {
                mMediaPlayer?.stop()
                isReady = false
            }
        }

        init()
    }

    private fun init() {
        mMediaPlayer = MediaPlayer()
        val attribute = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        mMediaPlayer?.setAudioAttributes(attribute)
        val afd = applicationContext.resources.openRawResourceFd(R.raw.guitar_background)
        try {
            mMediaPlayer?.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        mMediaPlayer?.setOnPreparedListener {
            isReady = true
            mMediaPlayer?.start()
        }

        mMediaPlayer?.setOnErrorListener { _, _, _ -> false }
    }

    private fun compatView() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}