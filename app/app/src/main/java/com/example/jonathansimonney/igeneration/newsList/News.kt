package com.example.jonathansimonney.igeneration.newsList

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

class News {
    val title: String = ""

    @SerializedName("byline")
    val author: String = ""

    @SerializedName("published_date")
    val stringDate: String=""

    @SerializedName("url")
    val link: String = ""

    fun getDateAsLong() :Long{
        val cal = Calendar.getInstance()
        val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE)
        cal.time = sdf.parse(stringDate)// all done

        val convertedDate = cal.timeInMillis

        return convertedDate
    }
}
