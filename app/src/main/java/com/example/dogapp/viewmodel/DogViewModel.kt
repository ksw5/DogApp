package com.example.dogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogapp.DogApi
import com.example.dogapp.model.network.DogApiResponse
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {
    private val _apiResponse = MutableLiveData<DogApiResponse>()
    val apiResponse: LiveData<DogApiResponse> = _apiResponse

    private var _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

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
            _status.value = DogApi.retrofitService.getRandomDogImageByBreed(breed!!).status!!

        }

    }

    fun getPreviousDog() {

    }
}