package com.example.lab0.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.lab0.utils.Constants.Companion.CAT_TABLE
import com.google.gson.annotations.SerializedName
@Entity(tableName = CAT_TABLE)
data class Cat(@SerializedName("name")
               val name: String = "",
               @SerializedName("width")
               val width: Int = 0,
               @PrimaryKey
               @SerializedName("id")
               val id: String = "",
               @SerializedName("url")
               val url: String = "",
               @SerializedName("height")
               val height: Int = 0)