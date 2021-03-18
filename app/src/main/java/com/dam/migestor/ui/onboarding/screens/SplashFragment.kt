 package com.dam.migestor.ui.onboarding.screens

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dam.migestor.R

 class SplashFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

//aplica tema diferente para la 'splashscreen'.
        this.activity?.setTheme(R.style.Base_MiGestor_SplashTheme)

//Presentación de la app a los usuarios que acceden por primera vez, si el usuario ya pasó por la presentación le envia al 'Login''.
//control en la 'ThirdScreen' almacenado como 'sharedPreferences'.

            Handler(Looper.getMainLooper()).postDelayed({
                if(onBoardingFinished()){
                    findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                    // val intent = Intent(activity, LoginActivity::class.java)
                    //activity?.startActivity(intent)
                   // activity?.finish()
                }else{
                    findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
                }
            }, 3000)

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

     private fun onBoardingFinished(): Boolean {
         val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
         return sharedPref.getBoolean("Finished", false)
     }
}