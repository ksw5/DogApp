package com.example.dogapp

import android.app.Application
import com.example.dogapp.model.data.DogDatabase
import com.example.dogapp.model.repository.DogRepository

class DogApplication : Application() {
    val database: DogDatabase by lazy { DogDatabase.getInstance(this) }
    val repository: DogRepository by lazy { DogRepository(database)}
}