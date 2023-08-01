package com.yeasinhproject.kotlinviewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.yeasinhproject.kotlinviewpager.screens.FirstScreen
import com.yeasinhproject.kotlinviewpager.screens.SecondScreen
import com.yeasinhproject.kotlinviewpager.screens.ThirdScreen


class OnBoardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, viewgroup: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_on_boarding, viewgroup, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        val dotsIndicator = view.findViewById<DotsIndicator>(R.id.dots_indicator)

        viewPager.adapter = adapter
        dotsIndicator.attachTo(viewPager)

        return view
    }


}