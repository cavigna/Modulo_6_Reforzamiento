package com.example.indicesremoto.utils

import android.annotation.SuppressLint
import android.icu.util.Calendar
import java.text.SimpleDateFormat
import java.util.*

class Utilidades {

    companion object{
        @SuppressLint("NewApi")
        val currentTime: Calendar = Calendar.getInstance()
        @SuppressLint("NewApi")
        val currentDate: Date = fromTimestamp(currentTime.timeInMillis)!!

        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val HOY = sdf.format(currentDate)


    }
}