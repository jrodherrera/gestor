package com.dam.migestor.ui

import android.app.ActivityOptions
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import com.dam.migestor.R
import com.dam.migestor.databinding.ActivityTransferBinding
import kotlinx.android.synthetic.main.activity_transfer.*
import kotlinx.android.synthetic.main.activity_transfer.view.*

class TransferActivity : AppCompatActivity(), View.OnClickListener {

//Vinculacion de vista
    private lateinit var binding: ActivityTransferBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransferBinding.inflate(layoutInflater)
        val view = binding.root
        val transition = ActivityOptions.makeSceneTransitionAnimation(this)
        val operation = getString(R.string.title_transfer)
        setContentView(view)

//modifica el texto según selección del 'chekbox'
        view.transfer_CHK_seller.setOnClickListener(this)

//añade el titulo del trámite correspondiente
        view.transfer_TV_title.text = operation
    }

//funcion para el 'checkbox'
    override fun onClick(v: View?) {
        val buyer = getString(R.string.fill_in_buyer)
        val seller= getString(R.string.fill_in_seller)
        v as CheckBox
        var isChecked: Boolean = v.isChecked
        when(v.id){
            R.id.transfer_CHK_seller ->if (isChecked){
                transfer_TV_txt.text = buyer
            }else transfer_TV_txt.text  = seller

        }
    }
}