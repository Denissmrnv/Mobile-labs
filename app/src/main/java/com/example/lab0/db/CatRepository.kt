package com.example.lab0.db

import com.example.lab0.data.Cat
import kotlinx.coroutines.flow.Flow

interface CatRepository {
    fun getCatsFromRoom(): Flow<List<Cat>>
    fun getCatFromRoom(id: Int): Flow<Cat>
    fun addCatToRoom(cat: Cat)
    fun addCatListToRoom(cats: List<Cat>)
    fun updateCatInRoom(cat: Cat)
    fun deleteCatFromRoom(cat: Cat)
}