package com.example.joinapplication.Flagment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.joinapplication.R
import kotlinx.android.synthetic.main.fragment_mentor_search.*
import kotlinx.android.synthetic.main.fragment_school_search.*

class mentorSearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mentor_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mentorList_Recycler_MentorFragment.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        mentorList_Recycler_MentorFragment.setHasFixedSize(true)
    }
}
