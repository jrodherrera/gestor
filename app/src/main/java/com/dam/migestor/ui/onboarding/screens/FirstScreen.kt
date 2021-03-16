package com.dam.migestor.ui.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dam.migestor.R
import com.dam.migestor.databinding.FragmentFirstScreenBinding
import androidx.viewpager2.widget.ViewPager2

import kotlinx.android.synthetic.main.fragment_first_screen.view.*

class FirstScreen : Fragment() {

//Best practices: Recomendaciones google para optimizacion de memoria.
    private var binding: FragmentFirstScreenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        // Inflate the layout for this fragment
        binding = FragmentFirstScreenBinding.inflate(inflater, container, false)
        val view = binding!!.root
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        view.first_screen_TVnext.setOnClickListener { viewPager?.currentItem = 1 }

        return view
    }

//libera memoria
    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }

}