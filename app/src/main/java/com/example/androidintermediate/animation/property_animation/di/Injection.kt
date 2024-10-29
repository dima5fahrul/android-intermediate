package com.example.androidintermediate.animation.property_animation.di

import android.content.Context
import com.example.androidintermediate.animation.property_animation.data.UserRepository
import com.example.androidintermediate.animation.property_animation.data.pref.UserPreference
import com.example.androidintermediate.animation.property_animation.data.pref.dataStore

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepository.getInstance(pref)
    }
}