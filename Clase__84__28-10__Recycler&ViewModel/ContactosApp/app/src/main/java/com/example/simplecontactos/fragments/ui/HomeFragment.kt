package com.example.simplecontactos.fragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.simplecontactos.R
import com.example.simplecontactos.databinding.FragmentHomeBinding
import com.example.simplecontactos.viewmodel.ContactoViewModel
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: ContactoViewModel by activityViewModels()

    private lateinit var tvNombre: TextInputLayout
    private lateinit var tvTel: TextInputLayout
    private lateinit var btnAgregar: Button
    private lateinit var bottomNav: BottomNavigationView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        with(binding) {
            tvNombre = txNombre
            tvTel = txNumero
            btnAgregar = bAgregar
            this@HomeFragment.bottomNav = bottomNav

        }

        btnAgregar.setOnClickListener {
            val nombre = tvNombre.editText?.text.toString()
            val tel = tvTel.editText?.text.toString()
            if (nombre.isNotEmpty() && tel.isNotEmpty()) {

                viewModel.onGuardar(nombre, tel)

                findNavController().navigate(R.id.listFragment)
            }


        }

//        bottomNav.setOnNavigationItemSelectedListener {
//            when(it.itemId){
//                R.id.menu_nombre -> findNavController().navigate(R.id.homeFragment)
//            }
//        }

        return binding.root
    }


}


