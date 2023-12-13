package com.example.lab0.db

import com.example.lab0.data.Cat

class CatRepositoryImpl(private val catDao: CatDao): CatRepository {
    override fun getCatsFromRoom() = catDao.getCats()
    override fun getCatFromRoom(id: Int) = catDao.getCat(id)
    override fun addCatToRoom(cat: Cat) = catDao.addCat(cat)
    override fun addCatListToRoom(cats: List<Cat>) = catDao.addCats(cats)
    override fun updateCatInRoom(cat: Cat) = catDao.updateCat(cat)
    override fun deleteCatFromRoom(cat: Cat) = catDao.deleteCat(cat)
}