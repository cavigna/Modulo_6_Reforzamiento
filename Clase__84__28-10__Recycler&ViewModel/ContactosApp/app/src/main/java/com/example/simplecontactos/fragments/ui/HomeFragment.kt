package com.example.simplecontactos.fragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.simplecontactos.R
import com.example.simplecontactos.databinding.FragmentHomeBinding
import com.example.simplecontactos.utils.hideKeyboard
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



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        with(binding) {
            tvNombre = txNombre
            tvTel = txNumero
            btnAgregar = bAgregar


        }

        hideKeyboard()
        btnAgregar.setOnClickListener {

            val nombre = tvNombre.editText?.text.toString()
            val tel = tvTel.editText?.text.toString()

            if (nombre.isNotEmpty() && tel.isNotEmpty()) {

                viewModel.onGuardar(nombre, tel)

                Toast.makeText(context, "Dale dale, esta agregado!", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(context, "Debe Completar todos los campos, Gil!!!", Toast.LENGTH_SHORT).show()
            }


        }
        return binding.root
    }


}


