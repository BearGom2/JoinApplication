package com.example.joinapplication.Flagment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                MainFlagment()
            }
            1 -> {
                SearchFlagment()
            }
            2 -> {
                MessageFlagment()
            }
            3 -> {
                ProfileFlagment()
            }
            4 -> {
                SettingFlagment()
            }

            else -> {
                MainFlagment()
            }
        }
    }

    override fun getCount(): Int {
        return 5
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return null
    }


}

