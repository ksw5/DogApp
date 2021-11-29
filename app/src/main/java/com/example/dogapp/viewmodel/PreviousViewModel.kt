package com.example.dogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogapp.DogApi
import com.example.dogapp.model.data.Dog
import com.example.dogapp.model.data.DogDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class PreviousViewModel(private val dogDao: DogDao) : ViewModel(){

    val previousDogs: LiveData<List<Dog>>
        get() = _previousDogs

    private val _previousDogs: MutableLiveData<List<Dog>> = MutableLiveData()

    init {
        observePreviousDogs()
    }


    fun handleDogs(dog: List<Dog>) {
        _previousDogs.value = dog
    }

    private fun observePreviousDogs() {
        viewModelScope.launch {
            dogDao.getPreviousDogs()
                .flowOn(Dispatchers.IO)
                .collect { handleDogs(it) }
        }
    }

    fun showPreviousDogs(): Flow<List<Dog>> = dogDao.getPreviousDogs()
}