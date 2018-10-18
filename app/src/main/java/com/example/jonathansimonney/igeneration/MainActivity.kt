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

    data class Tab(val title :String, val fragment: Fragment)

    var tabHashMap :HashMap<String, Tab> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTabsData()

        setCurrentTab("news")
        setMenuListener()
    }

    private fun setTabsData(){
        tabHashMap["books"] = Tab(resources.getString(R.string.books), BooksFragment.newInstance())
        tabHashMap["news"] = Tab(resources.getString(R.string.news), NewsFragment.newInstance())
        tabHashMap["forum"] = Tab(resources.getString(R.string.forum), ForumFragment.newInstance())
        tabHashMap["club_igen"] = Tab(resources.getString(R.string.club_igen), ClubIgenFragment.newInstance())
        tabHashMap["settings"] = Tab(resources.getString(R.string.settings), SettingsFragment.newInstance())
    }

    private fun setCurrentTab(newTabIndex :String){
        val newTab = tabHashMap[newTabIndex] ?: Tab(resources.getString(R.string.news), NewsFragment.newInstance())
        setFragment(newTab.fragment)
        setToolbarTitle(newTab.title)
    }

    private fun setFragment(fragment :Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.myFragmentContainer, fragment)
        fragmentTransaction.commit()
    }

    private fun setToolbarTitle(newTitle :String) {
        val myToolbar = findViewById<Toolbar>(R.id.z_toolbar)
        myToolbar.title = newTitle
        setSupportActionBar(myToolbar)
    }

    private fun setMenuListener(){
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.action_news -> setCurrentTab("news")
                R.id.action_books -> setCurrentTab("books")
                R.id.action_forum -> setCurrentTab("forum")
                R.id.action_club_igen -> setCurrentTab("club_igen")
                R.id.action_settings -> setCurrentTab("settings")
            }
            true
        }
    }
}
