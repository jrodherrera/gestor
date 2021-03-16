package com.dam.migestor.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.dam.migestor.R
import com.dam.migestor.databinding.FragmentLoginBinding
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {

//Best practices: Recomendaciones google para optimizacion de memoria.
    private var binding: FragmentLoginBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding!!.root
        val tiepass = view.login_TIE_pass
        val tilpass = view.login_TIL_pass
        val tieuser = view.login_TIE_user_name
        val tiluser = view.login_TIL_user_name
        val longMaxPassword = 8



        //limpiamos el errores
        tiepass.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus){
                tilpass.error = ""
            }
        }
        tieuser.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus){
                tiluser.error = ""
            }
        }


        tiepass.setOnClickListener {
            val value = it as TextInputEditText
            val size = value.text.toString().length

            if(size < 8){
                tilpass.error =  getString(R.string.characters, size, longMaxPassword)
            } else {
                tilpass.error = ""
            }
        }

//mostramos error si contraseña es <8
        tiepass.addTextChangedListener {
            val size = it!!.length

            if(size < 8){
                tilpass.error =  getString(R.string.characters, size, longMaxPassword )
            }else {
                tilpass.error = ""
            }
        }

//mostramos error si contraseña o nombre usuario estan vacios
        view.login_BTN_go.setOnClickListener {
            if(tiepass.text.isNullOrBlank()){
                tilpass.error = getString(R.string.empty_password)
                return@setOnClickListener
            }else if(tieuser.text.isNullOrBlank()){
                tiluser.error = getString(R.string.empty_username)
                return@setOnClickListener
            }else{
                /////////////////////////////////////tras iniciar sesion////////////////////////////////////////////////
                //val intent = Intent(this, HomeActivity::class.java)
                //startActivity(intent, transition.toBundle())



            }
        }

//registro
        view.login_BTN_reg.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            // val intent = Intent(this, RegisterActivity::class.java)
           // startActivity(intent, transition.toBundle())
        }
//recordar contraseña
        view.login_BTN_forgot.setOnClickListener {
           findNavController().navigate(R.id.action_loginFragment_to_forgotPassFragment)
             // val intent = Intent(this, ForgotPasswordActivity::class.java)
            //startActivity(intent, transition.toBundle())
        }

        /*para hacer transicion se mete como opcion en el intent
        val intent = Intent(this, Activity2::Class.java)
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
*/

        return (view)
    }

    //libera memoria
    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }
}

