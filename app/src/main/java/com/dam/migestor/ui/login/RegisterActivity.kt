package com.dam.migestor.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dam.migestor.R
import com.dam.migestor.databinding.ActivityRegisterBinding
import kotlinx.android.synthetic.main.activity_register.view.*

class RegisterActivity : AppCompatActivity() {

//Vinculación de vista
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view =  binding.root
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%!\\-_?&])(?=\\S+\$).{8,}"
        val user = view.register_TIE_user_name
        val phone = view.register_TIE_phone
        val email = view.register_TIE_email
        val pass = view.register_TIE_password
        val pass2 = view.register_TIE_password2

        setContentView(view)
/*
        view.register_BTN_register.setOnClickListener {
            if(user.text.isNullOrBlank() ){
                val txt = getString(R.string.phone_contain_value)

                Toast.makeText(applicationContext, txt, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(phone.text.isNullOrBlank()){
                val txt = getString(R.string.username_contain_value)
                Toast.makeText(applicationContext, txt, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(email.text.toString().trim{it <= ' '}.matches(emailPattern.toRegex())){
                val txt = getString(R.string.error_email)
                Toast.makeText(applicationContext, txt, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(pass.text.toString().trim{it <= ' '}.matches(passwordPattern.toRegex())){
                val txt = getString(R.string.include_password)
                Toast.makeText(applicationContext, txt, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(pass.text.toString() != pass2.text.toString()){
                val txt = getString(R.string.not_match_password)
                Toast.makeText(applicationContext, txt, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
        */

    }

}