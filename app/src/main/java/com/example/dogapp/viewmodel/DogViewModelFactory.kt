package com.example.dogapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dogapp.model.data.DogDao

class DogViewModelFactory(
    private val dogDao: DogDao
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DogViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DogViewModel(dogDao) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }
}