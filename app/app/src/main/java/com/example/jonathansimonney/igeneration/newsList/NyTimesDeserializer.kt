package com.example.jonathansimonney.igeneration.newsList

import com.google.gson.JsonDeserializer
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.google.gson.JsonDeserializationContext
import java.lang.reflect.Type


class NyTimesDeserializer : JsonDeserializer<List<News>>
{
    @Throws(JsonParseException::class)
    override fun deserialize(je: JsonElement, type: Type, jdc: JsonDeserializationContext): List<News> {
        // Get the "results" element from the parsed JSON
        val arrayNewsJson = je.asJsonObject.get("results")

        // Deserialize it. You use a new instance of Gson to avoid infinite recursion
        // to this deserializer
        return Gson().fromJson<List<News>>(arrayNewsJson, News::class.java)

    }
}