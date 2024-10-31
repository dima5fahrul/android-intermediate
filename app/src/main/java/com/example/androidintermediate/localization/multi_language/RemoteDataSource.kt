package com.example.androidintermediate.localization.multi_language

import android.content.Context
import com.example.androidintermediate.R

class RemoteDataSource(private val context: Context) {
    fun getDetailProduct(): ProductModel {
        return ProductModel(
            name = context.getString(R.string.localization_name),
            store = context.getString(R.string.localization_store),
            size = context.getString(R.string.localization_size),
            color = context.getString(R.string.localization_color),
            desc = context.getString(R.string.localization_description),
            image = R.drawable.shoes,
            date = context.getString(R.string.localization_date),
            rating = context.getString(R.string.localization_rating),
            price = context.getString(R.string.price),
            countRating = context.getString(R.string.countRating)
        )
    }
}