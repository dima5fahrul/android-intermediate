package com.example.androidintermediate.advanced_database.database_paging.data

import androidx.lifecycle.LiveData
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.androidintermediate.advanced_database.database_paging.database.QuoteDatabase
import com.example.androidintermediate.advanced_database.database_paging.network.ApiService
import com.example.androidintermediate.advanced_database.database_paging.network.QuoteResponseItem

class QuoteRepository(
    private val quoteDatabase: QuoteDatabase,
    private val apiService: ApiService
) {
    fun getQuote(): LiveData<PagingData<QuoteResponseItem>> {

        @OptIn(ExperimentalPagingApi::class)
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            remoteMediator = QuoteRemoteMediator(quoteDatabase, apiService),
            pagingSourceFactory = {
//                QuotePagingSource(apiService)
                quoteDatabase.quoteDao().getAllQuote()
            }
        ).liveData
    }
}