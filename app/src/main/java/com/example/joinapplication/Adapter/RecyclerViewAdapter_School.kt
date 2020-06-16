package com.example.joinapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.joinapplication.Data.Row
import com.example.joinapplication.R
import kotlinx.android.synthetic.main.mentor_search_list.view.*
import kotlinx.android.synthetic.main.school_search_list.view.*

class RecyclerViewAdapter_School(val context: Context, val School: List<Row>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        val holder: RecyclerView.ViewHolder
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.school_search_list, parent, false)
        holder =
            schSearchViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return School.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var schSearchViewHolder: schSearchViewHolder = holder as schSearchViewHolder
        schSearchViewHolder.bindItem(School[position])
    }


    class schSearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(info: Row) {
            itemView.schName_Tv_School_search_list.text = info.SchoolName
            itemView.schEngName_Tv_School_search_list.text = info.engSchoolName
            itemView.schAddress_Tv_School_search_list.text = info.address
        }

    }


}