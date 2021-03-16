package com.dam.migestor.ui.login

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.dam.migestor.R
import com.dam.migestor.ui.HomeActivity

import com.dam.migestor.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_login.view.*

class LoginActivity : AppCompatActivity() {

//Vinculación de vista
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view =  binding.root
        val pass = view.login_TIE_password
        val longMaxPassword = 8
        val transition = ActivityOptions.makeSceneTransitionAnimation(this)
        setContentView(view)
/*
//limpiamos el errores
        view.login_TIE_password.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus){
                view.login_TIL_password.error = ""
            }
        }

        view.login_TIE_password.setOnClickListener {
            val value = it as TextInputEditText
            val size = value.text.toString().length

            if(size < 8){
                view.login_TIL_password.error =  getString(R.string.characters, size, longMaxPassword)//"//Caracteres $size/8"
            } else {
                view.login_TIL_password.error = ""
            }
        }

//mostramos error si contraseña es <8
        view.login_TIE_password.addTextChangedListener {
            val size = it!!.length


            if(size < 8){
                view.login_TIL_password.error =  getString(R.string.characters, size, longMaxPassword )
            }else {
                view.login_TIL_password.error = ""
            }
        }

//mostramos error si contraseña esta vacia
        view.login_BTN_start.setOnClickListener {
            if(pass.text.isNullOrBlank()){
                view.login_TIL_password.error = getString(R.string.empty_password)
                return@setOnClickListener
            }else{
                /////////////////////////////////////tras iniciar sesion////////////////////////////////////////////////
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent, transition.toBundle())
            }
        }

//registro
        view.login_BTN_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent, transition.toBundle())
        }
//recordar contraseña
        view.login_BTN_forgot.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent, transition.toBundle())
        }

        /*para hacer transicion se mete como opcion en el intent
        val intent = Intent(this, Activity2::Class.java)
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
*/
*/
    }
}