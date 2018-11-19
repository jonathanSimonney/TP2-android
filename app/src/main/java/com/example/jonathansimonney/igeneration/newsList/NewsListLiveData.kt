package com.example.jonathansimonney.igeneration.newsList

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import android.view.View
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_news.*
import java.text.SimpleDateFormat
import java.util.*

class NewsListLiveData : MutableLiveData<List<News>>() {
    override fun onActive() {
        val database = FirebaseDatabase.getInstance()


        val listener = object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val ret = ArrayList<News>()

                for(news in dataSnapshot.children) {
                    val title = news.child("title").getValue(String::class.java)
                    val author = news.child("author").getValue(String::class.java)
                    val date = news.child("date").getValue(String::class.java)

                    val cal = Calendar.getInstance()
                    val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE)
                    cal.time = sdf.parse(date)// all done

                    val convertedDate = cal.timeInMillis

                    if (title != null && author != null && date != null){
                        ret.add(News(title, author, convertedDate))
                    }
                }

                postValue(ret)
            }

            override fun onCancelled(dbErr: DatabaseError) {
                Log.e("warning", "database error ${dbErr.message}")
            }
        }

        database.getReference("news").addValueEventListener(listener)
    }

    override fun onInactive() {
        //tt stopper
    }
}