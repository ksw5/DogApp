package com.example.dogapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dogapp.DogApplication
import com.example.dogapp.model.data.DogDao
import com.example.dogapp.model.repository.DogRepository

class DogViewModelFactory(
    val dogRepository: DogRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DogViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DogViewModel(dogRepository) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }
}