package com.hazewritescode.friendzover.activities

import android.net.Uri
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import com.hazewritescode.friendzover.HomeFeed
import com.hazewritescode.friendzover.R
import com.hazewritescode.friendzover.adapters.MainPagerAdapter
import com.hazewritescode.friendzover.adapters.RecipeRecyclerViewAdapter
import com.hazewritescode.friendzover.adapters.RegistrationPagerAdapter
import com.hazewritescode.friendzover.fragments.FriendFragment
import com.hazewritescode.friendzover.fragments.MainFragment
import com.hazewritescode.friendzover.fragments.registration_first
import com.hazewritescode.friendzover.fragments.registration_second
import com.nshmura.recyclertablayout.RecyclerTabLayout


class MainActivity : AppCompatActivity(), MainFragment.OnMainFragmentInteractionListener,FriendFragment.OnFriendFragmentInteractionListener {

    override fun onMainFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFriendFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val manager = supportFragmentManager
        val mainPager: ViewPager = findViewById(R.id.mainViewPager)
        val recyclerTabLayout = findViewById<RecyclerTabLayout>(R.id.mainTabs)

        mainPager.adapter = MainPagerAdapter(manager, listOf(
            MainFragment(), FriendFragment()))
        recyclerTabLayout.setUpWithViewPager(mainPager)

    }

}


