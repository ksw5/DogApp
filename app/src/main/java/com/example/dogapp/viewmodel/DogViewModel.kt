package com.example.dogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogapp.DogApi
import com.example.dogapp.model.data.Dog
import com.example.dogapp.model.data.DogDao
import com.example.dogapp.model.network.DogApiResponse
import kotlinx.coroutines.launch

class DogViewModel(
    val dogDao: DogDao
) : ViewModel() {
    private val _apiResponse = MutableLiveData<DogApiResponse>()
    val apiResponse: LiveData<DogApiResponse> = _apiResponse

    private val _status = DogApiResponse("", "success").status
    val status = _status


    init {
        getNewDog()
    }

    fun getNewDog() {
        try {
            viewModelScope.launch {
                _apiResponse.value = DogApi.retrofitService.getRandomDogImage()
            }
        } catch (e: Exception) {
            "Failure: ${e.message}"
        }
    }

    fun getBreed(breed: String) {
        viewModelScope.launch {
            _apiResponse.value = DogApi.retrofitService.getRandomDogImageByBreed(breed!!)


        }
    }

        suspend fun insert(dog: Dog) {
            dogDao.insert(dog)
        }
    }




