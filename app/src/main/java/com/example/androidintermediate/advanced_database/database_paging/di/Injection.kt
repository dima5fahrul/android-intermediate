package com.example.androidintermediate.advanced_database.database_paging.di

import android.content.Context
import com.example.androidintermediate.advanced_database.database_paging.data.QuoteRepository
import com.example.androidintermediate.advanced_database.database_paging.database.QuoteDatabase
import com.example.androidintermediate.advanced_database.database_paging.network.ApiConfig

object Injection {
    fun provideRepository(context: Context): QuoteRepository {
        val database = QuoteDatabase.getDatabase(context)
        val apiService = ApiConfig.getApiService()
        return QuoteRepository(database, apiService)
    }
}