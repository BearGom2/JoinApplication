package com.example.joinapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.joinapplication.Data.Adapter
import com.example.joinapplication.Data.Client
import com.example.joinapplication.Data.Row
import com.example.joinapplication.Data.infoFirst
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        recycler.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recycler.setHasFixedSize(true)
        loadData()
    }

    private fun setAdapter(School: List<Row>) {
        recycler.layoutManager = LinearLayoutManager(this)
        val mAdapter = Adapter(this, School)
        recycler.adapter = mAdapter
        Log.d("Response:", "Successful")
    }

    private fun loadData() {
        val call_R: Call<infoFirst> = Client.getClient.getSchool()
        call_R.enqueue(object : Callback<infoFirst> {
            override fun onFailure(call: Call<infoFirst>, t: Throwable) {
                Toast.makeText(applicationContext, "asdfasdf", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<infoFirst>,
                response: Response<infoFirst>
            ) {
                var School : ArrayList<Row> = arrayListOf()
                val sList = response.body()!!.schoolList.toString().split("Row")
                for (a in 1..(sList.size -1 )) {
                    var str = sList[a].replace("(", "")
                    str = str.replace(")", "")
                    str = str.replace("]", "")
                    var sList_s = str.split(",")
                    var info: ArrayList<String> = arrayListOf("a")
                    for (a in 0..(sList_s.size-1)) {
                        info.addAll(sList_s[a].split("="))
                    }
                    val r:Row = Row(info[2],info[4],info[6],info[8],info[10])
                    School.add(r)
                }
                setAdapter(School)
            }
        })
    }
}