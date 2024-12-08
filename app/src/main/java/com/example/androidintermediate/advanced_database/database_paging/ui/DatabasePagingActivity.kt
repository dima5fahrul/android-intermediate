package com.example.androidintermediate.advanced_database.database_paging.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidintermediate.advanced_database.database_paging.adapter.QuoteListAdapter
import com.example.androidintermediate.databinding.ActivityDatabasePagingBinding

class DatabasePagingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDatabasePagingBinding
    private val viewModel: DatabasePagingViewModel by viewModels {
        DatabasePagingViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDatabasePagingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvQuote.layoutManager = LinearLayoutManager(this)

        getData()
    }

    private fun getData() {
        val adapter = QuoteListAdapter()
        binding.rvQuote.adapter = adapter
        viewModel.quote.observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }
}