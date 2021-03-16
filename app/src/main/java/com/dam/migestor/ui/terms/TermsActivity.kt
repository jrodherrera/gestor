package com.dam.migestor.ui.terms
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.dam.migestor.R
import com.dam.migestor.databinding.ActivityTermsBinding
import com.dam.migestor.ui.HomeActivity
import kotlinx.android.synthetic.main.activity_terms.*

import kotlinx.android.synthetic.main.activity_terms.view.*

class TermsActivity : AppCompatActivity() {

//Vinculacion de vista
    private lateinit var binding: ActivityTermsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsBinding.inflate(layoutInflater)
        val view = binding.root
        val transition = ActivityOptions.makeSceneTransitionAnimation(this)

        //obtenemos el preferenceManager
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)

        //clave:valor del sharedPreferences
        val key = "agree"
        setContentView(view)

        var checkAgree = prefs.getBoolean(key, false)

//mostramos aviso de que los térmisnos fueron aceptados.
        if(checkAgree){
            terms_BTN_agree.visibility = View.INVISIBLE
            terms_TV_agree.visibility = View.VISIBLE
        }

//boton aceptar
        view.terms_BTN_agree.setOnClickListener {
            val editor = prefs.edit()
            editor.putBoolean(key, true)
            editor.apply()
           // Toast.makeText(this, getString(R.string.terms_agree, ), Toast.LENGTH_SHORT).show()
            terms_BTN_agree.visibility = View.INVISIBLE
            terms_TV_agree.visibility = View.VISIBLE
        }

//boton volver a 'home'
        view.terms_BTN_back.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent, transition.toBundle())
        }
    }
}