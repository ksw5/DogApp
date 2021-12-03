package com.example.dogapp.model.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface DogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dog: Dog)


    @Query("SELECT * FROM previousDogs")
    fun getPreviousDogs(): Flow<List<Dog>>



}