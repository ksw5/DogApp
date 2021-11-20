package com.example.dogapp.model.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Dog::class], version = 1)
abstract class DogDatabase : RoomDatabase() {
    abstract fun getDogDao(): DogDao

    companion object {
        @Volatile
        private var INSTANCE: DogDatabase? = null
        fun getInstance(context: Context): DogDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    DogDatabase::class.java,
                    "dog_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}