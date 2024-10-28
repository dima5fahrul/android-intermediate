package com.example.androidintermediate.advanced_ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidintermediate.R
import com.example.androidintermediate.advanced_ui.custom_button.CustomButtonAndEditTextActivity
import com.example.androidintermediate.advanced_ui.custom_view.CustomViewActivity
import com.example.androidintermediate.databinding.ActivityAdvancedUiBinding

class AdvancedUiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdvancedUiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAdvancedUiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMoveToCustomButton.setOnClickListener { onButtonClicked(it) }
        binding.btnMoveToCustomView.setOnClickListener { onButtonClicked(it) }

        compatView()
    }

    private fun onButtonClicked(it: View?) {
        when (it?.id) {
            R.id.btn_move_to_custom_button -> {
                val intent = intent
                intent.setClass(this, CustomButtonAndEditTextActivity::class.java)
                startActivity(intent)
            }
            
            R.id.btn_move_to_custom_view -> {
                val intent = intent
                intent.setClass(this, CustomViewActivity::class.java)
                startActivity(intent)
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