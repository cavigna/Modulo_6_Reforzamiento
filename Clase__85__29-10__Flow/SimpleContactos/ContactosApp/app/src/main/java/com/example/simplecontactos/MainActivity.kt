package com.example.simplecontactos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation

import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment


import com.example.simplecontactos.databinding.ActivityMainBinding
import com.example.simplecontactos.viewmodel.ContactoViewModel

class MainActivity : AppCompatActivity() {

    val viewModel : ContactoViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bottomNav = binding.bottomNav

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController = navHostFragment.navController

        bottomNav.setOnItemSelectedListener{item->
            when (item.itemId) {
                R.id.menu_agregar ->navController.navigate(R.id.homeFragment)
                R.id.menu_lista -> navController.navigate(R.id.listFragment)

            }
            true
        }
    }
}
