package com.dam.migestor.ui.login

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dam.migestor.databinding.ActivityForgotPasswordBinding
import kotlinx.android.synthetic.main.activity_forgot_password.view.*

class ForgotPasswordActivity : AppCompatActivity() {

//Vinculación de vista
    private lateinit var  binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        val view =  binding.root
        val transition = ActivityOptions.makeSceneTransitionAnimation(this)
        setContentView(view)

//enviar password
    view.forgot_BTN_send.setOnClickListener {
        
    }


//volver a login
    view.forgot_BTN_back.setOnClickListener {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent, transition.toBundle())
    }



    }
}