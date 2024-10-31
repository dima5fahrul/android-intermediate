package com.example.androidintermediate.media.sound_pool

import android.media.SoundPool
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidintermediate.R

class SoundPoolActivity : AppCompatActivity() {
    private lateinit var sp: SoundPool
    private var soundId = 0
    private var spLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sound_pool)

        compatView()

        sp = SoundPool.Builder()
            .setMaxStreams(10)
            .build()

        sp.setOnLoadCompleteListener { _, _, status ->
            if (status == 0) {
                spLoaded = true
            } else {
                Toast.makeText(this, "Failed to load sound", Toast.LENGTH_SHORT).show()
            }
        }

        soundId = sp.load(this, R.raw.clinking_glasses, 1)

        val btnSound = findViewById<Button>(R.id.btn_sound_pool)

        btnSound.setOnClickListener {
            if (spLoaded) {
                sp.play(soundId, 1f, 1f, 0, 0, 1f)
            }
        }
    }

    private fun compatView() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}