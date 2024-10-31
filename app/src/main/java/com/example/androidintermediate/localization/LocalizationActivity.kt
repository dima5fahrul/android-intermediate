package com.example.androidintermediate.localization

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidintermediate.R
import com.example.androidintermediate.databinding.ActivityLocalizationBinding
import com.example.androidintermediate.localization.multi_language.MultiLanguageActivity

class LocalizationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLocalizationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLocalizationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        compatView()

        binding.btnMoveToMultiLanguage.setOnClickListener { onButtonClicked(it) }
    }

    private fun onButtonClicked(it: View?) {
        when (it?.id) {
            R.id.btn_move_to_multi_language ->
                startActivity(setClass(MultiLanguageActivity::class.java))
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