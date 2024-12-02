package com.example.androidintermediate.geo_location

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidintermediate.R
import com.example.androidintermediate.databinding.ActivityGeoLocationBinding
import com.example.androidintermediate.geo_location.geofence.MapsFenceActivity
import com.example.androidintermediate.geo_location.google_maps.MapsActivity
import com.example.androidintermediate.geo_location.location_tracker.MapsTrackerActivity

class GeoLocationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGeoLocationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGeoLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnMoveToGoogleMaps.setOnClickListener { onButtonClicked(it) }
        binding.btnMoveToMapsTracker.setOnClickListener { onButtonClicked(it) }
        binding.btnMoveToMapsFence.setOnClickListener { onButtonClicked(it) }
    }

    private fun setClass(cls: Class<*>): Intent = Intent(this, cls)

    private fun onButtonClicked(it: View?) {
        when (it?.id) {
            R.id.btn_move_to_google_maps -> startActivity(setClass(MapsActivity::class.java))
            R.id.btn_move_to_maps_tracker -> startActivity(setClass(MapsTrackerActivity::class.java))
            R.id.btn_move_to_maps_fence -> startActivity(setClass(MapsFenceActivity::class.java))
        }
    }
}