package com.example.lab0.db

import android.util.Log
import com.example.lab0.data.Cat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count

class CatRepositoryImpl(
    private val catDao: CatDao
) : CatRepository {

    override fun getCatsFromRoom(): Flow<List<Cat>> {
        Log.d("CatRepositoryImpl", "getCatsFromRoom: ${catDao.getCats()}")

        return catDao.getCats()
    }
    override fun getCatFromRoom(id: Int) = catDao.getCat(id)
    override fun addCatToRoom(cat: Cat) = catDao.addCat(cat)
    override fun addCatListToRoom(cats: List<Cat>) {
        Log.d("CatRepositoryImpl", "addCatListToRoom: $cats")
        catDao.addCats(cats)
    }
    override fun updateCatInRoom(cat: Cat) = catDao.updateCat(cat)
    override fun deleteCatFromRoom(cat: Cat) = catDao.deleteCat(cat)
}