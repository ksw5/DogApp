package com.example.dogapp

import com.example.dogapp.model.network.DogApiResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://dog.ceo/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface ApiRequest {
    @GET("breeds/image/random")
    suspend fun getRandomDogImage(): DogApiResponse

    @GET("breeds/image/random")
    suspend fun getRandomImageByUrl(): DogApiResponse


    @GET("breed/{breed}/images/random")
    suspend fun getRandomDogImageByBreed(@Path("breed") breed: String): DogApiResponse

}

object DogApi {
    val retrofitService: ApiRequest by lazy { retrofit.create(ApiRequest::class.java) }
}