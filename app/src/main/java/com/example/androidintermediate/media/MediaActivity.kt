package com.example.androidintermediate.media

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidintermediate.R
import com.example.androidintermediate.databinding.ActivityMediaBinding
import com.example.androidintermediate.media.camera_gallery.CameraGalleryActivity
import com.example.androidintermediate.media.exo_player.ExoPlayerActivity
import com.example.androidintermediate.media.media_player.MediaPlayerActivity
import com.example.androidintermediate.media.sound_pool.SoundPoolActivity

class MediaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMediaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMediaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        compatView()

        binding.btnMoveToSoundPool.setOnClickListener { onButtonClicked(it) }
        binding.btnMoveToMediaPlayer.setOnClickListener { onButtonClicked(it) }
        binding.btnMoveToExoPlayer.setOnClickListener { onButtonClicked(it) }
        binding.btnMoveToCameraGallery.setOnClickListener { onButtonClicked(it) }
    }

    private fun onButtonClicked(it: Any) {
        when (it) {
            binding.btnMoveToSoundPool -> startActivity(setClass(SoundPoolActivity::class.java))
            binding.btnMoveToMediaPlayer -> startActivity(setClass(MediaPlayerActivity::class.java))
            binding.btnMoveToExoPlayer -> startActivity(setClass(ExoPlayerActivity::class.java))
            binding.btnMoveToCameraGallery -> startActivity(setClass(CameraGalleryActivity::class.java))
        }
    }

    private fun setClass(cls: Class<*>): Intent = Intent(this, cls)


    private fun compatView() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}