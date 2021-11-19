package com.example.dogapp.model.network

import com.squareup.moshi.Json

data class DogApiResponse(
    @Json(name = "message")
    val message: String,

    @Json(name = "status")
    val status: String
)