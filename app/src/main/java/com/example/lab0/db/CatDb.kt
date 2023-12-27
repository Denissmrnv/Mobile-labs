package com.example.lab0.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.lab0.data.Cat

@Database(entities = [Cat::class], version = 1, exportSchema = false)
abstract class CatDb : RoomDatabase() {
    abstract fun catDao(): CatDao
}