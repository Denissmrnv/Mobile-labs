package com.example.lab0.api

object Common {
    // ~/study/_4_Kurs/_Mobile/LR4_Server/licensing-service

    val retrofitService: ApiService
        get() = RetrofitHelper.getClient("http://192.168.144.1:8080/v1/").create(ApiService::class.java)
//        get() = RetrofitHelper.getClient("https://api.thecatapi.com/v1/images/").create(ApiService::class.java)
}