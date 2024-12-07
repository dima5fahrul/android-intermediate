package com.example.androidintermediate.advanced_database

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidintermediate.R
import com.example.androidintermediate.advanced_database.database_relation.DatabaseRelationActivity
import com.example.androidintermediate.databinding.ActivityAdvancedDatabaseBinding

class AdvancedDatabaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdvancedDatabaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAdvancedDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        compatView()
        
        binding.btnMoveToDatabaseRelation.setOnClickListener { onButtonClicked(it) }
    }

    private fun setClass(cls: Class<*>): Intent = Intent(this, cls)

    private fun onButtonClicked(it: View?) {
        when (it?.id) {
            R.id.btn_move_to_database_relation -> startActivity(setClass(DatabaseRelationActivity::class.java))
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