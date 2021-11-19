package com.example.dogapp.model.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface DogDao {

    @Insert
    suspend fun insert(vararg dog: Dog)

    @Query("SELECT * FROM previousDogs WHERE url = :url")
    suspend fun getImageUrl(url : String) : Dog


    @Query("SELECT * FROM previousDogs")
    suspend fun getPreviousDogs(): Flow<List<Dog>>

}