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

//        val listener = object: ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                val ret = ArrayList<News>()
//
//                for(news in dataSnapshot.children) {
//                    val title = news.child("title").getValue(String::class.java)
//                    val author = news.child("author").getValue(String::class.java)
//                    val date = news.child("date").getValue(String::class.java)
//                    val link = news.child("link").getValue(String::class.java)
//
//                    val cal = Calendar.getInstance()
//                    val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE)
//                    cal.time = sdf.parse(date)// all done
//
//                    val convertedDate = cal.timeInMillis
//
//                    if (title != null && author != null && date != null && link != null){
//                        ret.add(News(title, author, convertedDate, link))
//                    }
//                }
//
//                postValue(ret)
//            }
//
//            override fun onCancelled(dbErr: DatabaseError) {
//                Log.e("warning", "database error ${dbErr.message}")
//            }
//        }
//
//        database.getReference("news").addValueEventListener(listener)
    }

    override fun onInactive() {
        //tt stopper
    }
}