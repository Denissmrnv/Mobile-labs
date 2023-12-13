package com.example.lab0.di

import android.content.Context
import androidx.room.Room
import com.example.lab0.db.CatDao
import com.example.lab0.db.CatDb
import com.example.lab0.db.CatRepository
import com.example.lab0.db.CatRepositoryImpl
import com.example.lab0.utils.Constants.Companion.CAT_TABLE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideCatDb(//доступ к базе данных
        @ApplicationContext
        context : Context
    ) = Room.databaseBuilder(
        context,
        CatDb::class.java,
        CAT_TABLE
    ).build()
    @Provides
    fun provideCatDao(//доступ к Data Access Object
        catDb: CatDb
    ) = catDb.catDao()
    @Provides
    fun provideCatRepository(//доступ к репозиторию с данными
        catDao: CatDao
    ): CatRepository = CatRepositoryImpl(
        catDao = catDao
    )
}