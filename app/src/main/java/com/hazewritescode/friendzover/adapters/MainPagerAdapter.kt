package com.hazewritescode.friendzover.adapters


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

// 1
class MainPagerAdapter(fragmentManager: FragmentManager, private val viewFragments: List<Fragment>) :
    FragmentStatePagerAdapter(fragmentManager) {

    // 2
    override fun getItem(position: Int): Fragment {
        return viewFragments[position]
    }

    // 3
    override fun getCount(): Int {
        return viewFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        val titles = arrayOf("Recipes", "Friends")
        return titles[position]
    }
}