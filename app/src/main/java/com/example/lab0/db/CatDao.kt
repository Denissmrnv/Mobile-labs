package com.example.lab0.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.lab0.data.Cat
import com.example.lab0.utils.Constants.Companion.CAT_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface CatDao {
    @Query("SELECT * FROM $CAT_TABLE ORDER BY id ASC")
    fun getCats(): Flow<List<Cat>>
    @Query("SELECT * FROM $CAT_TABLE WHERE id = :id")
    fun getCat(id: Int): Flow<Cat>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCat(cat: Cat)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCats(cat: List<Cat>)
    @Update
    fun updateCat(cat: Cat)
    @Delete
    fun deleteCat(cat: Cat)
}