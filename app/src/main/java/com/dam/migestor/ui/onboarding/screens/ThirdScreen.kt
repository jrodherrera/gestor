package com.dam.migestor.ui.onboarding.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dam.migestor.R
import com.dam.migestor.databinding.FragmentThirdScreenBinding
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_third_screen.view.*

class ThirdScreen : Fragment() {

//Best practices: Recomendaciones google para optimizacion de memoria.
    private var binding: FragmentThirdScreenBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle?): View? {

//Dirige a 'Login' mediante el componente Navigation y pone a True para no volver a mostrar las pantallas de presentación al usuario
        binding = FragmentThirdScreenBinding.inflate(inflater, container, false)
        val view = binding!!.root

        /*//salir a una activity
        view.third_screen_TVfinnish.setOnClickListener{
            onBoardingFinished()
            val intent = Intent(activity, LoginActivity::class.java)
            activity?.startActivity(intent)
            activity?.finish()
        }
        */
        view.third_screen_TVfinnish.setOnClickListener{
            findNavController().navigate(R.id.action_viewPagerFragment_to_loginFragment)
            onBoardingFinished()
        }
        return view
    }

//libera memoria
    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }

//Control de paso del usuario por la última pantalla de presentación
    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.putBoolean("Finished", true)
        editor.apply()
    }
}