package com.example.dogapp.viewmodel

import android.app.Application
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


    val previousDogs: MutableLiveData<List<Dog>>
        get() = _previousDogs

    private val _previousDogs: MutableLiveData<List<Dog>> = MutableLiveData()





    init {
        getNewDog()
    }

    fun getNewDog() {
        viewModelScope.launch {
            _apiResponse.value = DogApi.retrofitService.getRandomDogImage()
        }
    }

    fun getBreed(breed: String) {

        viewModelScope.launch {
            _apiResponse.value = DogApi.retrofitService.getRandomDogImageByBreed(breed!!)


        }
    }

    fun getDogImageUrl() {
        viewModelScope.launch {
            _apiResponse.value = DogApi.retrofitService.getRandomDogImage()

        }

    }


    suspend fun insert(dog: Dog) {
        dogDao.insert(dog)
    }

    fun handlePreviousDogs(dog: List<Dog>) {
        _previousDogs.value = dog
        }
    }




