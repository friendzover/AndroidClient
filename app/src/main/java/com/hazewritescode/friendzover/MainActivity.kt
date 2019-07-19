package com.hazewritescode.friendzover

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.OkHttpClient




class MainActivity : AppCompatActivity() {


    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                textMessage.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_friends -> {
                textMessage.setText("Friends")
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val recipeRecyclerView = findViewById<RecyclerView>(R.id.recipeRecyclerView)
        recipeRecyclerView.layoutManager = LinearLayoutManager(this)
        recipeRecyclerView.adapter = RecipeRecyclerViewAdapter()

        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        fetchJSON()
    }

    fun fetchJSON(){
        val url: String = getString(R.string.news_feed_api_key)

        val client = OkHttpClient()

    }
}


