package com.dam.migestor.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import com.dam.migestor.R
import com.dam.migestor.databinding.FragmentTransferBinding
import kotlinx.android.synthetic.main.fragment_transfer.view.*
import kotlinx.android.synthetic.main.fragment_transfer.*


class TransferFragment : Fragment() {

//Best practices: Recomendaciones google para optimizacion de memoria.
        private var binding: FragmentTransferBinding? = null

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            binding = FragmentTransferBinding.inflate(inflater, container, false )
            val view = binding!!.root
            val operation = getString(R.string.title_transfer)
            val buyer = getString(R.string.fill_in_buyer)
            val seller= getString(R.string.fill_in_seller)


//añade el titulo del trámite correspondiente
                view.transfer_TV_title.text = operation

//modifica el texto según selección del 'chekbox'
             view.transfer_CHK_seller.setOnClickListener(View.OnClickListener {
                 if (transfer_CHK_seller.isChecked) transfer_TV_txt.text = buyer
                 else transfer_TV_txt.text  = seller
             })



        return view
        }





/*
    //funcion para el 'checkbox'
    fun onClick(v: View?) {
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
*/
}