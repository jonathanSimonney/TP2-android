package com.example.jonathansimonney.igeneration.newsList

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.google.gson.GsonBuilder
import com.google.gson.Gson




class NewsListLiveData : MutableLiveData<List<News>>() {
    override fun onActive() {
        val api = Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/mostpopular/v2/mostemailed/Technology/")
                .addConverterFactory(
                        GsonConverterFactory.create())
                .build()
                .create(API::class.java)

        api.getArticles().enqueue(object : Callback<ArrayNewsWrapper> {
            override fun onResponse(call: Call<ArrayNewsWrapper>,
                                    response: Response<ArrayNewsWrapper>) {
                val news = response.body()

                postValue(news?.results)
            }

            override fun onFailure(call: Call<ArrayNewsWrapper>,
                          t: Throwable) {
                Log.d("jonathanNewsFound", t.message)
                t.printStackTrace()
            }
        })
    }

    override fun onInactive() {
        //tt stopper
    }
}