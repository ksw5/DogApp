package com.example.dogapp.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "previousDogs")
data class Dog(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "url")
    val url: String
)
