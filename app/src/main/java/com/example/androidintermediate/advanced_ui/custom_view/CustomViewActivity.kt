package com.example.androidintermediate.advanced_ui.custom_view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidintermediate.R

class CustomViewActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_custom_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.custom_view_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val seatView = findViewById<SeatsView>(R.id.seatsView)
        val button = findViewById<Button>(R.id.finishButton)

        button.setOnClickListener {
            seatView.seat?.let {
                Toast.makeText(
                    this,
                    getString(R.string.kursi_anda_nomor, it.name), Toast.LENGTH_SHORT
                ).show()
            } ?: run {
                Toast.makeText(
                    this,
                    getString(R.string.silahkan_pilih_kursi_terlebih_dahulu), Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}