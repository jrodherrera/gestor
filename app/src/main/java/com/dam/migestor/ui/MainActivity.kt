package com.dam.migestor.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dam.migestor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//Vinculación de vista
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

//Se agrega NavHostFragment a través de XML
// Fuente: https://developer.android.com/guide/navigation/navigation-getting-started
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}