package com.example.pizzeriajuanito.fragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.example.pizzeriajuanito.R
import com.example.pizzeriajuanito.databinding.FragmentDetailsBinding
import com.example.pizzeriajuanito.model.Pizza
import com.example.pizzeriajuanito.viewmodel.PizzaViewModel


class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel: PizzaViewModel by activityViewModels()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)

        var pizza = viewModel.pizza

        with(binding){
            tvNombre.text = "Felicitaciones ${pizza.cliente}, tu pizza va en camino!"
            tvdetalles.text = imprimir(pizza)
            tvtotal.text = "Total = ${pizza.total}"
        }






        return binding.root

    }

    fun imprimir(pizza:Pizza) :String{

        var resultado = """Tamaño : ${pizza.size}
            |
            |
        """.trimMargin()

        if (pizza.carne != 0) resultado    +=  "Carne:     ${pizza.carne}\n\n"
        if (pizza.pepe != 0) resultado     +=  "Peperoni:  ${pizza.pepe}\n\n"
        if (pizza.tocino != 0) resultado   +=  "Tocino:    ${pizza.tocino}\n\n"
        if (pizza.champ != 0) resultado    +=  "Champiñon: ${pizza.tocino}\n\n"
        if (pizza.tomate != 0) resultado   +=  "Tomate:    ${pizza.tomate}\n\n"
        if (pizza.choclo != 0) resultado   +=  "Choclo:    ${pizza.choclo}\n\n"
        if (pizza.aceituna != 0) resultado +=  "Aceituna:  ${pizza.aceituna}\n\n"


        return resultado
    }


}