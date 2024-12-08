package com.example.androidintermediate

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidintermediate.advanced_database.AdvancedDatabaseActivity
import com.example.androidintermediate.advanced_ui.AdvancedUiActivity
import com.example.androidintermediate.animation.AnimationActivity
import com.example.androidintermediate.databinding.ActivityMainBinding
import com.example.androidintermediate.firebase.FirebaseActivity
import com.example.androidintermediate.geo_location.GeoLocationActivity
import com.example.androidintermediate.localization.LocalizationActivity
import com.example.androidintermediate.media.MediaActivity
import com.example.androidintermediate.service.ServiceActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMoveToAdvancedUi.setOnClickListener { onButtonClicked(it) }
        binding.btnMoveToAnimation.setOnClickListener { onButtonClicked(it) }
        binding.btnMoveToLocalization.setOnClickListener { onButtonClicked(it) }
        binding.btnMoveToService.setOnClickListener { onButtonClicked(it) }
        binding.btnMoveToMedia.setOnClickListener { onButtonClicked(it) }
        binding.btnMoveToGeoLocation.setOnClickListener { onButtonClicked(it) }
        binding.btnMoveToAdvancedDatabase.setOnClickListener { onButtonClicked(it) }
        binding.btnMoveToFirebase.setOnClickListener { onButtonClicked(it) }

        compatView()
    }

    private fun setClass(cls: Class<*>): Intent = Intent(this, cls)

    private fun onButtonClicked(it: View?) {
        when (it?.id) {
            R.id.btn_move_to_advanced_ui -> startActivity(setClass(AdvancedUiActivity::class.java))
            R.id.btn_move_to_animation -> startActivity(setClass(AnimationActivity::class.java))
            R.id.btn_move_to_localization -> startActivity(setClass(LocalizationActivity::class.java))
            R.id.btn_move_to_service -> startActivity(setClass(ServiceActivity::class.java))
            R.id.btn_move_to_media -> startActivity(setClass(MediaActivity::class.java))
            R.id.btn_move_to_geo_location -> startActivity(setClass(GeoLocationActivity::class.java))
            R.id.btn_move_to_advanced_database -> startActivity(setClass(AdvancedDatabaseActivity::class.java))
            R.id.btn_move_to_firebase -> startActivity(setClass(FirebaseActivity::class.java))
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