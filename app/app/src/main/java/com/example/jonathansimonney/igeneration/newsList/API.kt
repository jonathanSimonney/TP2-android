package com.example.jonathansimonney.igeneration.newsList

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface API {
    @GET("7.json?api-key=d493703a408e43b19a1fd31806d4aaca")
    fun getArticles(): Call<ArrayNewsWrapper>

    @GET("{articleId}")
    fun getArticleById(
            @Path("articleId") id: String): Call<News>
}