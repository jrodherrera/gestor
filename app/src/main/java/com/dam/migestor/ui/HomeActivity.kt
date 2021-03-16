package com.dam.migestor.ui

import android.app.ActivityOptions
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.widget.TooltipCompat
import androidx.core.net.toUri
import com.dam.migestor.R
import com.dam.migestor.databinding.ActivityHomeBinding
import com.dam.migestor.ui.instructions.InstructionsStartOperationActivity
import com.dam.migestor.ui.terms.TermsActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.view.*

class HomeActivity : AppCompatActivity() {

//Vinculación de vista
    private lateinit var binding: ActivityHomeBinding


//variables para las animaciones
//Fuentes:   https://developer.android.com/training/animation/overview
//          https://www.youtube.com/watch?v=umCX1-Tq25k
    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim) }

//variable para activar o desativar la pulsacion
    private var clicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        val transition = ActivityOptions.makeSceneTransitionAnimation(this)
        setContentView(view)

//'listeners' para los botones flotantes
        view.home_FBT_option.setOnClickListener{
            onAddButtonClicked()
        }
        view.home_FBT_setting.setOnClickListener {

        }
        //Llama a las oficinas del gestor
        view.home_FBT_phone.setOnClickListener{
            val dialintent = Intent(Intent.ACTION_DIAL)
            dialintent.data = Uri.parse("tel:" + getString(R.string.office_number))
            startActivity(dialintent)
        }
        view.home_FBT_chat.setOnClickListener {

        }
        view.home_FBT_terms.setOnClickListener {
            val intent = Intent(this, TermsActivity::class.java)
            startActivity(intent)
        }

        //muestra informacion de los botones
        TooltipCompat.setTooltipText(home_FBT_setting, getString(R.string.settings))
        TooltipCompat.setTooltipText(home_FBT_phone, getString(R.string.calling))
        TooltipCompat.setTooltipText(home_FBT_chat, getString(R.string.chat))
        TooltipCompat.setTooltipText(home_FBT_terms, getString(R.string.terms_agree))
 //'listeners'  para los botones principales
 //iniciar trámite
        view.home_BTN_startoperation.setOnClickListener {
            val intent = Intent(this, InstructionsStartOperationActivity::class.java)
            startActivity(intent, transition.toBundle())
        }

//consultar trámite
        view.home_BTN_checkoperation.setOnClickListener {

        }

    }

//contiene las funciones para para las animaciones y la visibilidad de los 'floatingButtom'
    private fun onAddButtonClicked(){
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked
    }

//da visibilidad al ser pulsado
    private fun setVisibility(clicked: Boolean) {
        if(!clicked){
            home_FBT_setting.visibility = View.VISIBLE
            home_FBT_phone.visibility = View.VISIBLE
            home_FBT_chat.visibility = View.VISIBLE
            home_FBT_chat.visibility = View.VISIBLE
            home_FBT_terms.visibility = View.VISIBLE
        }else{
            home_FBT_setting.visibility = View.INVISIBLE
            home_FBT_phone.visibility = View.INVISIBLE
            home_FBT_chat.visibility = View.INVISIBLE
            home_FBT_terms.visibility = View.INVISIBLE
        }
    }

//lanza animaciones
    private fun setAnimation(clicked: Boolean) {
        if(!clicked){
            home_FBT_option.startAnimation(rotateOpen)
            home_FBT_setting.startAnimation(fromBottom)
            home_FBT_phone.startAnimation(fromBottom)
            home_FBT_chat.startAnimation(fromBottom)
            home_FBT_terms.startAnimation(fromBottom)
        }else{
            home_FBT_option.startAnimation(rotateClose)
            home_FBT_setting.startAnimation(toBottom)
            home_FBT_phone.startAnimation(toBottom)
            home_FBT_chat.startAnimation(toBottom)
            home_FBT_terms.startAnimation(toBottom)
        }
    }


}