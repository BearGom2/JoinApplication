package com.example.joinapplication.Flagment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.joinapplication.Adapter.ViewpagerAdapter_Search

import com.example.joinapplication.R
import com.example.joinapplication.SearchActivity
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.fragment_school_search.*

class schoolSearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_school_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        schList_Recycler_schFragment.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        schList_Recycler_schFragment.setHasFixedSize(true)
    }
}
