package com.example.jonathansimonney.igeneration

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_news_detail.*
import kotlinx.android.synthetic.main.fragment_news.*

class NewsDetailActivity : AppCompatActivity() {

    val REFRESH = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        this.title = "News details activity"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.settings_icon)

        toolbar.setNavigationOnClickListener {
            val data = Intent()
            data.putExtra("from", "up")
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }


    override fun onBackPressed() {
        val data = Intent()
        data.putExtra("from", "back")
        setResult(Activity.RESULT_CANCELED, data)
        super.onBackPressed()
    }

}
