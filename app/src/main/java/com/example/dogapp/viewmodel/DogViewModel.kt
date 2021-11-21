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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class DogViewModel(
    val dogDao: DogDao,
) : ViewModel() {
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


        }

    }

    suspend fun insert(dog: List<Dog>) {
        dogDao.insert(dog)
    }


    /*suspend fun addPreviousDog(dog: Dog) = dogRepository.insert()*/


    fun showPreviousDogs(): Flow<List<Dog>> = dogDao.getPreviousDogs()

  /*  fun getPreviousDog() {

    }
    fun allPreviousDogs(): Flow<List<Dog>> = dogDao.getPreviousDogs()

    fun getDogImageUrl(url : String) : Dog = dogDao.getImageUrl(url)

    fun addPreviousDog(dog: Dog) = dogDao.insert(dog)*/
}