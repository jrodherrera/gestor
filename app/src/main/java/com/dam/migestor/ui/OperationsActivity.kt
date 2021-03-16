package com.dam.migestor.ui

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dam.migestor.R
import com.dam.migestor.databinding.ActivityOperationsBinding
import kotlinx.android.synthetic.main.activity_operations.view.*

class OperationsActivity : AppCompatActivity() {

//Vinculación de vista
    private lateinit var binding: ActivityOperationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOperationsBinding.inflate(layoutInflater)
        val view = binding.root
        val transition = ActivityOptions.makeSceneTransitionAnimation(this)
        setContentView(view)

//boton cancelar
        view.operations_BTN_cancel.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent, transition.toBundle())
        }
//boton transferencias
        view.operations_BTN_transfer.setOnClickListener {
            val intent = Intent(this, TransferActivity::class.java)
            startActivity(intent, transition.toBundle())
        }


    }
}
