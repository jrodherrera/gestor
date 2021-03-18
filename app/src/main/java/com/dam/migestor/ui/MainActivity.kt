package com.dam.migestor.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.dam.migestor.R
import com.dam.migestor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ShowMenuHomeNav {

//Vinculación de vista
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

//Se agrega NavHostFragment a través de XML
// Fuente: https://developer.android.com/guide/navigation/navigation-getting-started
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//a navigation
        val bottomHomeNav = binding.bottomHomeNav
        val navController = findNavController(R.id.nav_host_fragment)
        bottomHomeNav.setupWithNavController(navController)
    }

//muestra el menu del Home Nav
    override fun showMenu() {
        binding.bottomHomeNav.visibility = View.VISIBLE
    }
//oculta el menu del Home Nav
    override fun hideMenu() {
        binding.bottomHomeNav.visibility = View.INVISIBLE
    }
}