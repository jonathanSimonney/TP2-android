package com.example.jonathansimonney.igeneration

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setToolbarTitle()
    }

    private fun setToolbarTitle() {
        val myToolbar = findViewById<View>(R.id.z_toolbar) as Toolbar
        myToolbar.title = "Actualités"
        setSupportActionBar(myToolbar)
    }
}
