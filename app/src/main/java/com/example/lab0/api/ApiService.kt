package com.example.lab0.api

import com.example.lab0.data.Cat
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
//    @GET("search?limit=10")
//    suspend fun getCats() : List<Cat>

    @GET("cats")
    suspend fun getCats() : List<Cat>

    @GET("cats/{name}")
    suspend fun getCatsByName(@Path("name") name: String) : List<Cat>
}