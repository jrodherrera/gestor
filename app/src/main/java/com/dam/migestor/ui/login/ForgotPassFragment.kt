package com.dam.migestor.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dam.migestor.R
import com.dam.migestor.databinding.FragmentForgotPassBinding
import kotlinx.android.synthetic.main.fragment_forgot_pass.view.*

class ForgotPassFragment : Fragment() {

//Best practices: Recomendaciones google para optimizacion de memoria.
    private var  binding: FragmentForgotPassBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentForgotPassBinding.inflate(inflater, container, false)
        val view = binding!!.root
    /*
    //enviar password
        view.forgot_BTN_send.setOnClickListener {

        }
    */

    //volver a login
        view.forgot_BTN_back.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPassFragment_to_loginFragment)
            //val intent = Intent(this, LoginActivity::class.java)
            //startActivity(intent, transition.toBundle())
        }

        return (view)
    }

    //libera memoria
    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }

}