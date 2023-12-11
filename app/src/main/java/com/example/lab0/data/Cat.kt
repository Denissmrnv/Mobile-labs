package com.example.lab0.data


import com.google.gson.annotations.SerializedName

data class Cat(@SerializedName("name")
               val name: String = "",
               @SerializedName("width")
               val width: Int = 0,
               @SerializedName("id")
               val id: String = "",
               @SerializedName("url")
               val url: String = "",
               @SerializedName("height")
               val height: Int = 0)