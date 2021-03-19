package com.dam.migestor.ui.terms

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.dam.migestor.R
import com.dam.migestor.databinding.FragmentTermsBinding
import com.dam.migestor.ui.MainActivity
import com.dam.migestor.ui.ShowMenuHomeNav
import kotlinx.android.synthetic.main.fragment_terms.view.*


class TermsFragment : Fragment() {

//Best practices: Recomendaciones google para optimizacion de memoria.
    private var binding: FragmentTermsBinding? = null

//variable para la interface que muestra/oculta el menu del home nav
    private var listener: ShowMenuHomeNav? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentTermsBinding.inflate(inflater, container, false)
        val view = binding!!.root
        val thisContext = container!!.context

        //obtenemos el preferenceManager
        val prefs = PreferenceManager.getDefaultSharedPreferences(thisContext)

        //clave:valor del sharedPreferences
        val key = "agree"

        var checkAgree = prefs.getBoolean(key, false)

//mostramos aviso de que los térmisnos fueron aceptados.
        if(checkAgree){
            view.terms_BTN_agree.visibility = View.INVISIBLE
            view.terms_TV_agree.visibility = View.VISIBLE
        }

//boton aceptar
        view.terms_BTN_agree.setOnClickListener {
            val editor = prefs.edit()
            editor.putBoolean(key, true)
            editor.apply()
            // Toast.makeText(this, getString(R.string.terms_agree, ), Toast.LENGTH_SHORT).show()
            view.terms_BTN_agree.visibility = View.INVISIBLE
            view.terms_TV_agree.visibility = View.VISIBLE
        }

//boton volver
        view.terms_BTN_back.setOnClickListener{
            findNavController().navigate(R.id.action_termsFragment_to_loginFragment)
        }


        return view
    }

    override fun onAttach(context: Context) {

        super.onAttach(context)
        listener = context as MainActivity
        //oculta el 'bottom menu'. no será nulo
        listener!!.hideMenu()

    }

    //libera memoria
    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }


}