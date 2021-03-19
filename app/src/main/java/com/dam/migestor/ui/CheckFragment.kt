package com.dam.migestor.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dam.migestor.R
import com.dam.migestor.databinding.FragmentCheckBinding
import kotlinx.android.synthetic.main.fragment_check.view.*


class CheckFragment : Fragment() {

    //Best practices: Recomendaciones google para optimizacion de memoria.
    private var binding: FragmentCheckBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentCheckBinding.inflate(inflater, container, false)
        val view = binding!!.root
        val transaction = activity?.supportFragmentManager?.beginTransaction()

//boton informacion
        view.check_FBT_info.setOnClickListener {
/*            transaction!!.replace(R.id.checkFragment, InstructionFragment())
            transaction.disallowAddToBackStack()
            transaction.commit()*/
            findNavController().navigate(R.id.instructionFragment)
        }



        return view
    }

    //libera memoria
    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }

}