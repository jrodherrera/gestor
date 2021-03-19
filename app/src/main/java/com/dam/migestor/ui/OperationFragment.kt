package com.dam.migestor.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.TooltipCompat
import com.dam.migestor.R
import com.dam.migestor.databinding.FragmentOperationBinding
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_operation.*
import kotlinx.android.synthetic.main.fragment_operation.view.*


class OperationFragment : Fragment() {

//Best practices: Recomendaciones google para optimizacion de memoria.
    private var binding: FragmentOperationBinding? = null

//variable para la interface que muestra el menu del home nav
    private var listener: ShowMenuHomeNav? = null

//variable para activar o desativar la pulsacion
    private var clicked = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOperationBinding.inflate(inflater, container, false)
        var view = binding!!.root

//a trámite transferencias
        view.operations_BTN_transfer.setOnClickListener {
            findNavController().navigate(R.id.action_operationFragment_to_transferFragment)

        }



//'listeners' para los botones flotantes
        view.operations_FBT_option.setOnClickListener{
            onAddButtonClicked()
        }
        view.operations_FBT_setting.setOnClickListener {

        }
        //Llama a las oficinas del gestor
        view.operations_FBT_phone.setOnClickListener{
            val dialintent = Intent(Intent.ACTION_DIAL)
            dialintent.data = Uri.parse("tel:" + getString(R.string.office_number))
            startActivity(dialintent)
        }
        view.operations_FBT_chat.setOnClickListener {

        }
        view.operations_FBT_terms.setOnClickListener {
            findNavController().navigate(R.id.action_operationFragment_to_instructionFragment)
        }

//muestra informacion de los botones flotantes

        TooltipCompat.setTooltipText(view.operations_FBT_setting, getString(R.string.settings))
        TooltipCompat.setTooltipText(view.operations_FBT_phone, getString(R.string.calling))
        TooltipCompat.setTooltipText(view.operations_FBT_chat, getString(R.string.chat))
        TooltipCompat.setTooltipText(view.operations_FBT_terms, getString(R.string.title_terms))

        return view
    }

//muestra el 'bottom menu'
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MainActivity
        ////muestra el menu del home nav. no será nulo
        listener!!.showMenu()

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
            operations_FBT_setting.visibility = View.VISIBLE
            operations_FBT_phone.visibility = View.VISIBLE
            operations_FBT_chat.visibility = View.VISIBLE
            operations_FBT_chat.visibility = View.VISIBLE
            operations_FBT_terms.visibility = View.VISIBLE
        }else{
            operations_FBT_setting.visibility = View.INVISIBLE
            operations_FBT_phone.visibility = View.INVISIBLE
            operations_FBT_chat.visibility = View.INVISIBLE
            operations_FBT_terms.visibility = View.INVISIBLE
        }
    }

//lanza animaciones

    private fun setAnimation(clicked: Boolean) {

//variables para las animaciones
//Fuentes:   https://developer.android.com/training/animation/overview
//          https://www.youtube.com/watch?v=umCX1-Tq2
        val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.rotate_open_anim) }
        val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.rotate_close_anim) }
        val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.from_bottom_anim) }
        val toBottom: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.to_bottom_anim) }

        if(!clicked){
            operations_FBT_option.startAnimation(rotateOpen)
            operations_FBT_setting.startAnimation(fromBottom)
            operations_FBT_phone.startAnimation(fromBottom)
            operations_FBT_chat.startAnimation(fromBottom)
            operations_FBT_terms.startAnimation(fromBottom)
        }else{
            operations_FBT_option.startAnimation(rotateClose)
            operations_FBT_setting.startAnimation(toBottom)
            operations_FBT_phone.startAnimation(toBottom)
            operations_FBT_chat.startAnimation(toBottom)
            operations_FBT_terms.startAnimation(toBottom)
        }
    }

    

//libera memoria
    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }

}