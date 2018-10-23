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
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    data class Tab(val title :String, val fragment: Fragment, val menuId: Int)

    var tabHashMap :HashMap<String, Tab> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTabsData()

        setCurrentTab("news")
        setMenuListener()
    }

    fun changeTab(newTabIndex :String){
        val newTab = setCurrentTab(newTabIndex)
        bottom_navigation.selectedItemId = newTab.menuId
    }

    private fun setTabsData(){
        tabHashMap["books"] = Tab(resources.getString(R.string.books), BooksFragment.newInstance(), R.id.action_books)
        tabHashMap["news"] = Tab(resources.getString(R.string.news), NewsFragment.newInstance(), R.id.action_news)
        tabHashMap["forum"] = Tab(resources.getString(R.string.forum), ForumFragment.newInstance(), R.id.action_forum)
        tabHashMap["club_igen"] = Tab(resources.getString(R.string.club_igen), ClubIgenFragment.newInstance(), R.id.action_club_igen)
        tabHashMap["settings"] = Tab(resources.getString(R.string.settings), SettingsFragment.newInstance(), R.id.action_settings)
    }

    private fun setCurrentTab(newTabIndex :String) :Tab{
        val newTab = tabHashMap[newTabIndex] ?: Tab(resources.getString(R.string.news), NewsFragment.newInstance(), R.id.action_news)
        setFragment(newTab.fragment)
        setToolbarTitle(newTab.title)
        return newTab
    }

    private fun setFragment(fragment :Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.myFragmentContainer, fragment)
        fragmentTransaction.commit()
    }

    private fun setToolbarTitle(newTitle :String) {
        z_toolbar.title = newTitle
        setSupportActionBar(z_toolbar)
    }

    private fun setMenuListener(){
        bottom_navigation.setOnNavigationItemSelectedListener {
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
