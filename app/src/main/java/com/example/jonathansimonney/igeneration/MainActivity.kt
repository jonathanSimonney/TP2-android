package com.example.jonathansimonney.igeneration

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.Toolbar
import android.view.View
import com.example.jonathansimonney.igeneration.R.id.index



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setToolbarTitle()
        setFragment(NewsFragment.newInstance())
        setMenuListener()
    }

    private fun setFragment(fragment :Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.myFragmentContainer, fragment)
        fragmentTransaction.commit()
    }

    private fun setToolbarTitle() {
        val myToolbar = findViewById<View>(R.id.z_toolbar) as Toolbar
        myToolbar.title = resources.getString(R.string.news)
        setSupportActionBar(myToolbar)
    }

    private fun setMenuListener(){
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.action_news -> setFragment(NewsFragment.newInstance())
                R.id.action_books -> setFragment(BooksFragment.newInstance())
                R.id.action_forum -> setFragment(ForumFragment.newInstance())
                R.id.action_club_igen -> setFragment(ClubIgenFragment.newInstance())
                R.id.action_settings -> setFragment(SettingsFragment.newInstance())
            }
            true
        }
    }
}
