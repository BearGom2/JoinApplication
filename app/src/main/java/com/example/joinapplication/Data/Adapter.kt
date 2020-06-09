package com.example.joinapplication.Data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.joinapplication.R
import kotlinx.android.synthetic.main.search_list.view.*

class Adapter(val context: Context, val School: List<Row>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        val holder: RecyclerView.ViewHolder
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_list, parent, false)
        holder = SearchViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return School.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var SearchViewHolder: SearchViewHolder = holder as SearchViewHolder
        SearchViewHolder.bindItem(School[position])

    }

    class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(info: Row) {
            itemView.name.text = info.SchoolName
            itemView.EngName.text = info.engSchoolName
            itemView.address.text = info.address
        }

    }


}