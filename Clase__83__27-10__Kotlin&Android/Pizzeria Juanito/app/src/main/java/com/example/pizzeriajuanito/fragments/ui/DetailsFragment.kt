package com.example.pizzeriajuanito.fragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.pizzeriajuanito.R
import com.example.pizzeriajuanito.databinding.FragmentDetailsBinding
import com.example.pizzeriajuanito.viewmodel.PizzaViewModel


class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    val viewModel: PizzaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)

        var total = viewModel.pizza.total
        var cliente = viewModel.pizza.cliente

        binding.textView.text = total.toString()
        binding.textView2.text = cliente.toString()



        return binding.root

    }


}