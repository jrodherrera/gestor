package com.dam.migestor.ui

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dam.migestor.R
import com.dam.migestor.databinding.ActivityHomeBinding
import com.dam.migestor.databinding.ActivityThanksBinding
import com.dam.migestor.ui.instructions.InstructionsStartOperationActivity
import kotlinx.android.synthetic.main.activity_thanks.view.*

class ThanksActivity : AppCompatActivity() {

//Vinculación de vista
    private lateinit var binding: ActivityThanksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThanksBinding.inflate(layoutInflater)
        val view = binding.root
        val transition = ActivityOptions.makeSceneTransitionAnimation(this)
        setContentView(view)

//boton vovler
        view.thanks_BTN_back.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent, transition.toBundle())
        }
//boton salir
        view.thanks_BTN_exit.setOnClickListener {

        }
    }
}