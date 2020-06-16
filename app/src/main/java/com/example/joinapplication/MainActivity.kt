package com.example.joinapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.joinapplication.Adapter.ViewPagerAdapter_Main
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_flagment.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mTablayout: TabLayout = tablayout_Main


        val fmAdapter = ViewPagerAdapter_Main(
            supportFragmentManager
        )
        viewPager_Main.adapter = fmAdapter
        tablayout_Main.setupWithViewPager(viewPager_Main)

    }

    fun clickEvent(view: View) {
        val intent = Intent(baseContext, SearchActivity::class.java)
        if (search_Edt_MainFlag.length() > 0) {
            intent.putExtra("SearchData", search_Edt_MainFlag.text.toString())
            startActivity(intent)
            finish()
        }
    }

}
