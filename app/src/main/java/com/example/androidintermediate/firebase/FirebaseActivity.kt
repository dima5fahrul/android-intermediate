package com.example.androidintermediate.firebase

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidintermediate.R
import com.example.androidintermediate.databinding.ActivityFirebaseBinding
import com.example.androidintermediate.firebase.firebase_auth.FirebaseAuthActivity

class FirebaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirebaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirebaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        compatView()

        binding.btnMoveToFirebaseAuth.setOnClickListener { onButtonClicked(it) }
    }

    private fun setClass(cls: Class<*>): Intent = Intent(this, cls)

    private fun onButtonClicked(it: View?) {
        when (it?.id) {
            R.id.btn_move_to_firebase_auth -> startActivity(setClass(FirebaseAuthActivity::class.java))
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