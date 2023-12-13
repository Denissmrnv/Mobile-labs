package com.example.lab0.db

import android.media.Image
import androidx.room.TypeConverter
import com.google.gson.Gson

class ImageConverter {
    @TypeConverter
    fun fromImage(image: Image?): String {
        return Gson().toJson(image);
    }
    @TypeConverter
    fun toImage(data: String): Image? {
        return Gson().fromJson(data,Image::class.java)
    }
}