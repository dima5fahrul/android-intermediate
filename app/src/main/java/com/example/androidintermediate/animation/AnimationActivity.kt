package com.example.androidintermediate.animation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidintermediate.R
import com.example.androidintermediate.animation.property_animation.view.property_animation_main.PropertyAnimationActivity
import com.example.androidintermediate.databinding.ActivityAnimationBinding

class AnimationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("AnimationActivity", "onCreate: ")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMoveToPropertyAnimation.setOnClickListener { onButtonClicked(it) }

        viewCompat()
    }

    private fun setClass(cls: Class<*>): Intent = Intent(this, cls)

    private fun onButtonClicked(it: View?) {
        when (it?.id) {
            R.id.btn_move_to_property_animation ->
                startActivity(setClass(PropertyAnimationActivity::class.java))
        }
    }

    private fun viewCompat() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}