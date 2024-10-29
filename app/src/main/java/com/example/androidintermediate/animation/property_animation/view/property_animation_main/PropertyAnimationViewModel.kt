package com.example.androidintermediate.animation.property_animation.view.property_animation_main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidintermediate.animation.property_animation.data.UserRepository
import com.example.androidintermediate.animation.property_animation.data.pref.UserModel
import kotlinx.coroutines.launch

class PropertyAnimationViewModel(private val repository: UserRepository) : ViewModel() {
    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }
}