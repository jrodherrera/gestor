package com.dam.migestor.ui.instructions

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dam.migestor.R
import com.dam.migestor.databinding.ActivityInstructionsStartOperationBinding
import com.dam.migestor.databinding.ActivityOperationsBinding
import com.dam.migestor.ui.HomeActivity
import com.dam.migestor.ui.OperationsActivity
import kotlinx.android.synthetic.main.activity_instructions_start_operation.view.*

class InstructionsStartOperationActivity : AppCompatActivity() {

//Vinculación de vista
    private lateinit var binding: ActivityInstructionsStartOperationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInstructionsStartOperationBinding.inflate(layoutInflater)
        val view = binding.root
        val transition = ActivityOptions.makeSceneTransitionAnimation(this)
        setContentView(view)

        view.instruction_oper_BTN_next.setOnClickListener {
            val intent = Intent(this, OperationsActivity::class.java)
            startActivity(intent, transition.toBundle())
        }
    }
}