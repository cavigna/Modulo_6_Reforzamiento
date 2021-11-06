package com.example.indicesremoto.utils

import android.annotation.SuppressLint
import android.icu.util.Calendar
import java.text.SimpleDateFormat
import java.util.*


fun fromTimestamp(value: Long?): Date? {
    return value?.let { Date(it) }
}


fun dateToTimestamp(date: Date?): Long? {
    return date?.time?.toLong()
}

@SuppressLint("NewApi")
fun dameLaFecha():String{

    val currentTime: Calendar = Calendar.getInstance()
    val currentDate: Date = fromTimestamp(currentTime.timeInMillis)!!
    val sdf = SimpleDateFormat("dd-MM-yyyy")

    return sdf.format(currentDate)
}



