package com.example.joinapplication.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.joinapplication.Flagment.*

class ViewpagerAdapter_Search(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                schoolSearchFragment()
            }
            1 -> {
                mentorSearchFragment()
            }

            else -> {
                schoolSearchFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return null
    }
}