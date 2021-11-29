package com.example.dogapp.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dogapp.model.network.DogApiResponse
import com.example.dogapp.viewmodel.DogViewModel

@Entity(tableName = "previousDogs")
data class Dog(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "url")
    var url: String
)
