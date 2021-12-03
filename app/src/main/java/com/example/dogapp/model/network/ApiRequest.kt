package com.example.dogapp

import com.example.dogapp.model.data.Dog
import com.example.dogapp.model.network.DogApiResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Url


private const val BASE_URL = "https://dog.ceo/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val networkLoggingInterceptor =
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


val retrofit = Retrofit.Builder()
    .client(OkHttpClient.Builder().addInterceptor(networkLoggingInterceptor).build())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface ApiRequest {
    @GET("breeds/image/random")
    suspend fun getRandomDogImage(): DogApiResponse

    @GET("breed/{breed}/images/random")
    suspend fun getRandomDogImageByBreed(@Path("breed") breed: String): DogApiResponse

   @GET("breed/{breed}/images/random")
    fun randomDogBreedResponse(@Path("breed") breed: String): Call<DogApiResponse>

}

object DogApi {
    val retrofitService: ApiRequest by lazy { retrofit.create(ApiRequest::class.java) }
}