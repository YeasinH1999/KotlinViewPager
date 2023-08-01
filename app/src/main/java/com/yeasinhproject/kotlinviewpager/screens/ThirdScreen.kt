package com.yeasinhproject.kotlinviewpager.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.yeasinhproject.kotlinviewpager.R

class ThirdScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        val tvFinish : TextView = view.findViewById(R.id.tvFinish)

        tvFinish.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFragment_to_homeFragment)
            onBoardingFinished()
        }

        return view
    }

    private fun onBoardingFinished(){

        val sharedPreferences =
            requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        editor.putBoolean("finished", true)
        editor.apply()

    }

}