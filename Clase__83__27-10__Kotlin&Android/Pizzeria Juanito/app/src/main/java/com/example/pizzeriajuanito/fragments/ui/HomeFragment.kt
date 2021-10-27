package com.example.pizzeriajuanito.fragments.ui

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.pizzeriajuanito.R
import com.example.pizzeriajuanito.databinding.FragmentHomeBinding
import com.example.pizzeriajuanito.model.Pizza
import com.example.pizzeriajuanito.viewmodel.PizzaViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class HomeFragment : Fragment() {

    private val viewModel : PizzaViewModel by activityViewModels()

    private lateinit var binding: FragmentHomeBinding
    private lateinit var rbS: RadioButton
    private lateinit var rbM: RadioButton
    private lateinit var rbXl: RadioButton
    private lateinit var cbCarne: CheckBox
    private lateinit var cbPepe: CheckBox
    private lateinit var cbTocino: CheckBox
    private lateinit var cbChamp: CheckBox
    private lateinit var cbTomate: CheckBox
    private lateinit var cbChoclo: CheckBox
    private lateinit var cbAceituna: CheckBox
    private lateinit var tilNombreCliente: TextInputLayout
    private lateinit var boton :Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        hacerBinding()


        boton.setOnClickListener{
            var nombre  = tilNombreCliente.editText?.text.toString()
            var pizza = hacerPizza(nombre)
            Log.i("pizzeria", pizza.toString() )

            viewModel.pizza = pizza

            findNavController().navigate(R.id.detailsFragment)
        }





        return binding.root
    }

    fun hacerBinding() {

        with(binding) {
            rbS = rbSmall
            rbM = rbMedium
            this@HomeFragment.rbXl = rbXl


        }
        tilNombreCliente = binding.tilNombre
        cbCarne = binding.cbCarne
        cbPepe = binding.cbPeperoni
        cbTocino = binding.cbTocino
        cbChamp = binding.cbChamp
        cbTomate = binding.cbTomate
        cbChoclo = binding.cbChoclo
        cbAceituna = binding.cbAceituna
        boton = binding.boton
    }

    fun hacerPizza(nombreCliente: String): Pizza {

        var pizza = Pizza(nombreCliente)

//        val ingredientes = listOf(
//            cbCarne, cbPepe, cbTocino, cbChamp,
//            cbChoclo, cbTomate, cbAceituna
//        )
//        //var tam = listOf(rbS, rbM, rbXl)

        when {
            rbS.isChecked -> {
                pizza.precioSize = 1500
                pizza.size = "Pequeña"
            }
            rbM.isChecked -> {
                pizza.precioSize = 3000
                pizza.size = "Mediana"
            }
            rbXl.isChecked -> {
                pizza.precioSize = 5000
                pizza.size = "Familiar"
            }
            else -> pizza.precioSize = 0

        }

        if(!cbCarne.isChecked) pizza.carne =0
        if(!cbPepe.isChecked) pizza.pepe =0
        if(!cbTocino.isChecked) pizza.tocino =0
        if(!cbChamp.isChecked) pizza.champ =0
        if(!cbChoclo.isChecked) pizza.choclo =0
        if(!cbTomate.isChecked) pizza.tomate =0
        if(!cbAceituna.isChecked) pizza.aceituna =0






        pizza.sumarTotal()

        return pizza
    }

}


