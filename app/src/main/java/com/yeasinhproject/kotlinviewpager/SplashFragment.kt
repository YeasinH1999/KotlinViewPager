package com.yeasinhproject.kotlinviewpager

import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.android.material.progressindicator.CircularProgressIndicator

class SplashFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, viewgroup: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splash, viewgroup, false)

        val progressIndicator : CircularProgressIndicator = view.findViewById(R.id.progressIndicator)

        progressIndicator.max = 1000

        val currentProgress = 1000

        ObjectAnimator.ofInt(progressIndicator, "progress", currentProgress)
            .setDuration(1500)
            .start()

        val animTop = AnimationUtils.loadAnimation(context, R.anim.from_top)
        val animBottom = AnimationUtils.loadAnimation(context, R.anim.from_bottom)

        val imgSplash : ImageView = view.findViewById(R.id.imgSplash)
        val tvSplash : TextView = view.findViewById(R.id.tvSplash)

        imgSplash.animation = animTop
        tvSplash.animation = animBottom

        Handler(Looper.getMainLooper()).postDelayed({

            if (onBoardingFinished()){

                findNavController().navigate(R.id.navigate_splashFragment_to_homeFragment)

            } else {

                findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragment)
            }


        }, 1500)

        return view
    }


    private fun onBoardingFinished() : Boolean {

        val sharedPreferences =
            requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)

        return sharedPreferences.getBoolean("finished", false)

    }

}