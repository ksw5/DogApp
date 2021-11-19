package com.example.dogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogapp.DogApi
import com.example.dogapp.model.data.Dog
import com.example.dogapp.model.data.DogDao
import com.example.dogapp.model.network.DogApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class DogViewModel(private val dogDao: DogDao) : ViewModel() {
    private val _apiResponse = MutableLiveData<DogApiResponse>()
    val apiResponse: LiveData<DogApiResponse> = _apiResponse

    private var _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    fun allPreviousDogs(): Flow<List<Dog>> = dogDao.getPreviousDogs()

    suspend fun getDogImageUrl(url : String) : Dog = dogDao.getImageUrl(url)

    suspend fun addPreviousDog(dog: Dog) = dogDao.insert(dog)

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