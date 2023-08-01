package com.yeasinhproject.kotlinviewpager.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.yeasinhproject.kotlinviewpager.R

class SecondScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val nextTwo : TextView = view.findViewById(R.id.nextTwo)
        val viewPager : ViewPager2? = activity?.findViewById(R.id.view_pager)

        nextTwo.setOnClickListener {
            viewPager?.currentItem = 2
        }

        return view
    }
}