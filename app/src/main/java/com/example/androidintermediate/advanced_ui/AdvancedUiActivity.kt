package com.example.androidintermediate.advanced_ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidintermediate.R
import com.example.androidintermediate.advanced_ui.canvas_draw.CanvasDrawActivity
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
        binding.btnMoveToCanvasDraw.setOnClickListener { onButtonClicked(it) }

        compatView()
    }

    private fun setClass(cls: Class<*>): Intent = intent.setClass(this, cls)

    private fun onButtonClicked(it: View?) {
        when (it?.id) {
            R.id.btn_move_to_custom_button -> startActivity(setClass(CustomButtonAndEditTextActivity::class.java))

            R.id.btn_move_to_custom_view -> startActivity(setClass(CustomViewActivity::class.java))

            R.id.btn_move_to_canvas_draw -> startActivity(setClass(CanvasDrawActivity::class.java))
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