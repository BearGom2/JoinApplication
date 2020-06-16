package com.example.joinapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.joinapplication.Data.ClassRow
import com.example.joinapplication.R
import kotlinx.android.synthetic.main.mentor_search_list.view.*

class RecyclerViewAdapter_Mentor(val context: Context, val Class:List<ClassRow>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        val holder: RecyclerView.ViewHolder
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.mentor_search_list, parent, false)
        holder =
            RecyclerViewAdapter_Mentor.mentorSearchViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return Class.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var mentorSearchViewHolder: mentorSearchViewHolder = holder as mentorSearchViewHolder
        mentorSearchViewHolder.bindItem(Class[position])

    }

    class mentorSearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(info: ClassRow) {
            itemView.schName_Tv_mentor_search_list.text = info.SchoolName
            itemView.grade_Tv_mentor_search_list.text = info.grade
            itemView.departmentName_Tv_mentor_search_list.text = info.departmentName
        }

    }

}