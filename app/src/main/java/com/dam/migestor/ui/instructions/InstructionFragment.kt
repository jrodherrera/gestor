package com.dam.migestor.ui.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dam.migestor.databinding.FragmentInstructionBinding



class InstructionFragment : Fragment() {

//Best practices: Recomendaciones google para optimizacion de memoria.
    private var binding: FragmentInstructionBinding? = null

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        binding = FragmentInstructionBinding.inflate(inflater, container, false)
        val view = binding!!.root





        return view
    }

    //libera memoria
    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }

}