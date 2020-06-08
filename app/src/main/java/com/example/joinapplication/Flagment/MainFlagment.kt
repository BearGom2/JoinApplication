package com.example.joinapplication.Flagment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.joinapplication.LoginActivity
import com.example.joinapplication.MainActivity
import com.example.joinapplication.R
import kotlinx.android.synthetic.main.main_flagment.*


class MainFlagment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_flagment, container, false)

    }

    fun clickEvent(view: View) {
        val intent = Intent(activity, LoginActivity::class.java)
        startActivity(intent)}
}

