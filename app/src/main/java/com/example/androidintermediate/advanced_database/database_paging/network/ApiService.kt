package com.example.androidintermediate.advanced_database.database_paging.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("list")
    suspend fun getQuote(
        @Query("page") page: Int,
        @Query("limit") size: Int
    ): List<QuoteResponseItem>
}