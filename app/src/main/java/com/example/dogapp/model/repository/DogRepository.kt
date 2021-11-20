package com.example.dogapp.model.repository

import com.example.dogapp.DogApi
import com.example.dogapp.model.data.Dog
import com.example.dogapp.model.data.DogDatabase

class DogRepository(
    val database: DogDatabase
) {

    suspend fun getImageUrl(message: String) =
        DogApi.retrofitService.getRandomDogImage()

    fun insert(dog: Dog) = database.getDogDao().insert(dog)

    fun getAllPreviousDogs() = database.getDogDao().getPreviousDogs()

}