package com.example.joinapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.joinapplication.Adapter.RecyclerViewAdapter_Mentor
import com.example.joinapplication.Adapter.RecyclerViewAdapter_School
import com.example.joinapplication.Adapter.ViewpagerAdapter_Search
import com.example.joinapplication.Data.*
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.fragment_mentor_search.*
import kotlinx.android.synthetic.main.fragment_school_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val fmAdapter = ViewpagerAdapter_Search(
            supportFragmentManager
        )
        viewPager_Search.adapter = fmAdapter
        loadData_Sch()
        loadData_Men()
        fmAdapter.notifyDataSetChanged()
    }

    override fun onBackPressed() {
        val intent = Intent(baseContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun setAdapter_Sch(School: List<Row>) {
        schList_Recycler_schFragment.layoutManager = LinearLayoutManager(this)
        val mAdapter = RecyclerViewAdapter_School(this, School)
        schList_Recycler_schFragment.adapter = mAdapter
        Log.d("Response:", "Successful")
    }

    private fun loadData_Sch() {
        val Intent = intent
        val call_R: Call<infoFirst> =
            Client.getClient.getSchool(Intent.getStringExtra("SearchData"))
        call_R.enqueue(object : Callback<infoFirst> {
            override fun onFailure(call: Call<infoFirst>, t: Throwable) {
                Toast.makeText(applicationContext, "asdfasdf", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<infoFirst>,
                response: Response<infoFirst>
            ) {
                if (DataParser_Sch(response.body()!!).size > 0) {
                    setAdapter_Sch(DataParser_Sch(response.body()!!))
                } else {
                    Toast.makeText(applicationContext, "검색 결과가 존재하지 않습니다.", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }

    fun DataParser_Sch(response: infoFirst): ArrayList<Row> {
        var School: ArrayList<Row> = arrayListOf()
        val sList = response.toString().split("Row")
        for (a in 1..(sList.size - 1)) {
            var str = sList[a].replace("(", "")
            str = str.replace(")", "")
            str = str.replace("]", "")
            var sList_s = str.split(",")
            var info: ArrayList<String> = arrayListOf("a")
            for (a in 0..(sList_s.size - 1)) {
                info.addAll(sList_s[a].split("="))
            }
            if (info[2] == "특성화고" || info[2] == "특목고") {
                val r: Row = Row(info[2], info[4], info[6], info[8], info[10])
                School.add(r)
            }
        }
        return School
    }

    private fun setAdapter_Men(Class: List<ClassRow>) {
        mentorList_Recycler_MentorFragment.layoutManager = LinearLayoutManager(this)
        val mAdapter = RecyclerViewAdapter_Mentor(this, Class)
        mentorList_Recycler_MentorFragment.adapter = mAdapter
        Log.d("Response:", "Successful")
    }

    private fun loadData_Men() {
        val Intent = intent
        val call_R: Call<classInfo> =
            Client.getClient.getDepartment("7010911")
        call_R.enqueue(object : Callback<classInfo> {
            override fun onFailure(call: Call<classInfo>, t: Throwable) {
                Toast.makeText(applicationContext, "asdfasdf", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<classInfo>,
                response: Response<classInfo>
            ) {
                if (DataParser_Men(response.body()!!).size > 0) {
                    setAdapter_Men(DataParser_Men(response.body()!!))
                } else {
                    Toast.makeText(applicationContext, "검색 결과가 존재하지.", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }

    fun DataParser_Men(response: classInfo): ArrayList<ClassRow> {
        var Class: ArrayList<ClassRow> = arrayListOf()
        val sList = response.toString().split("ClassRow")
        for (a in 1..(sList.size - 1)) {
            var str = sList[a].replace("(", "")
            str = str.replace(")", "")
            str = str.replace("]", "")
            var sList_s = str.split(",")
            var info: ArrayList<String> = arrayListOf("a")
            for (a in 0..(sList_s.size - 1)) {
                info.addAll(sList_s[a].split("="))
            }
            if (info[8]=="1"){
                val r: ClassRow = ClassRow(info[2], info[4], info[6],info[8])
                Class.add(r)
            }
        }
        return Class
    }
}