package com.example.joinapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.joinapplication.Flagment.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mTablayout: TabLayout = tablayout


        val fmAdapter = ViewPagerAdapter(supportFragmentManager)
        ViewPager.adapter = fmAdapter
        tablayout.setupWithViewPager(ViewPager)

        mTablayout.getTabAt(0)?.setIcon(R.drawable.baseline_home)
        mTablayout.getTabAt(1)?.setIcon(R.drawable.search)
        mTablayout.getTabAt(2)?.setIcon(R.drawable.chat)
        mTablayout.getTabAt(3)?.setIcon(R.drawable.account_circle)
        mTablayout.getTabAt(4)?.setIcon(R.drawable.settings)

    }



    fun clickEvent(view: View) {
        val intent = Intent(baseContext, SearchActivity::class.java)
        startActivity(intent)
        finish()}

}
