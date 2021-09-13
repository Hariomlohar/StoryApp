package com.example.storyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.containt_main.*

class MainActivity : AppCompatActivity() ,NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close)
       toggle.isDrawerIndicatorEnabled = true
        drawer.addDrawerListener(toggle)

        toggle.syncState()

        navigationview.setNavigationItemSelectedListener(this)
        val storyTitle = resources.getStringArray(R.array.story_title)
        val story_contant = resources.getStringArray(R.array.story_contain)
        val story_image = resources.getStringArray(R.array.story_images)

        val adapter = ItemAdapter(storyTitle,story_contant,story_image)
        storylist.layoutManager = LinearLayoutManager(this)
        storylist.adapter=adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}