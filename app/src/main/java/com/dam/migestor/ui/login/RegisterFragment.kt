package com.dam.migestor.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dam.migestor.R
import com.dam.migestor.databinding.FragmentRegisterBinding
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_register.view.*


class RegisterFragment : Fragment() {

//Best practices: Recomendaciones google para optimizacion de memoria.
    private var binding: FragmentRegisterBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding!!.root




//control errores
        view.register_BTN_register.setOnClickListener {
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
            val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%!\\-_?&])(?=\\S+\$).{8,}"

            val tiepass1    = view.register_TIE_password
            val tiepass2    = view.register_TIE_password2
            val tiemail = view.register_TIE_email
            val tiename = view.register_TIE_user_name
            val tiephone    = view.register_TIE_phone
            val tilpass1    =view.register_TIL_password
            val tilpass2    =view.register_TIL_password2
            val tilmail = view.register_TIL_email
            val tilname = view.register_TIL_user_name
            val tilphone    = view.register_TIL_phone

            val values = listOf(tiemail, tiename, tiepass1, tiepass2, tiephone)

            var error = false

            values.forEach{
                if(it.getTxt().isBlank()) {
                    error = true
                    when(it.id){
                        R.id.register_TIE_email -> {
                            tilmail.error = getString(R.string.empty_field)
                        }
                        R.id.register_TIE_phone -> {
                            tilphone.error = getString(R.string.empty_phone)
                        }
                        R.id.register_TIE_password -> {
                            tilpass1.error = getString(R.string.empty_password)
                        }
                        R.id.register_TIE_password2 -> {
                            tilpass2.error = getString(R.string.empty_password)
                        }
                        R.id.register_TIE_user_name -> {
                            tilname.error = getString(R.string.empty_username)
                        }
                    }

                }
            }

            if(error) return@setOnClickListener

            if(tiemail.getTxt().trim{it <= ' '}.matches(emailPattern.toRegex())){
                tilmail.error = getString(R.string.error_email)
                return@setOnClickListener
            }
            if(tiepass1.getTxt().trim{it <= ' '}.matches(passwordPattern.toRegex())){
                tilpass1.error = getString(R.string.password_include)
                return@setOnClickListener
            }
            if(!tiepass1.getTxt().equals(tiepass2.getTxt())){
                val not_match = getString(R.string.password_not_match)
                tilpass1.error = not_match
                tilpass2.error = not_match
                return@setOnClickListener
            }
        }
        return (view)
    }

//valor a 'string'
    fun TextInputEditText.getTxt(): String {
        return text.toString()
    }

    //libera memoria
    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }

}