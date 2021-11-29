package com.example.dogapp

import android.app.Application
import com.example.dogapp.model.data.DogDatabase


class DogApplication : Application() {
    val database: DogDatabase by lazy { DogDatabase.getInstance(this) }

}