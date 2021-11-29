package com.example.dogapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dogapp.model.data.DogDao

class PreviousViewModelFactory(
    private val dogDao: DogDao
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PreviousViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PreviousViewModel(dogDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}