package com.example.indicesremoto.fragment.ui

import android.annotation.SuppressLint
import android.app.Application
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.indicesremoto.databinding.FragmentHomeBinding
import com.example.indicesremoto.di.IndiceApplication
import com.example.indicesremoto.utils.fromTimestamp
import com.example.indicesremoto.utils.montoToCLP
import com.example.indicesremoto.viewmodel.IndiceModelFactory
import com.example.indicesremoto.viewmodel.IndiceViewModel
import java.text.SimpleDateFormat
import java.util.*


class HomeFragment : Fragment() {

    private lateinit var  binding: FragmentHomeBinding

    private lateinit var app: Application


    val viewModel :IndiceViewModel by activityViewModels {
        IndiceModelFactory((app as IndiceApplication).appContainer.repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = requireActivity().application


    }

    @SuppressLint("NewApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        val currentTime: Calendar = Calendar.getInstance()
        val currentDate: Date = fromTimestamp(currentTime.timeInMillis)!!

        val sdf = SimpleDateFormat("dd-MM-yyyy")



        Log.i("fecha", sdf.format(currentDate))

        viewModel.dolarHoy.observe(viewLifecycleOwner,{
            binding.tvMontoDolar.text = montoToCLP(it.indicador[0].valor)
        })

        viewModel.euroHoy.observe(viewLifecycleOwner,{
            binding.tvMontoEuro.text = montoToCLP(it.indicador[0].valor)
        })


        viewModel.ufHoy.observe(viewLifecycleOwner, {
            binding.tvMontoUf.text = it.indicador[0].valor.toInt().toString()
            binding.tvMontoUf.text = montoToCLP(it.indicador[0].valor)
        })


        viewModel.utmHoy.observe(viewLifecycleOwner, {
            binding.tvMontoUtm.text = it.indicador[0].valor.toString()
        })



        return binding.root

    }


}