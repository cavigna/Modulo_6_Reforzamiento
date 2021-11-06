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
import com.example.indicesremoto.viewmodel.IndiceModelFactory
import com.example.indicesremoto.viewmodel.IndiceViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.coroutineScope
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

        binding.tvMontoUf.text = viewModel.ufHoyMutable.value?.indicador?.get(0)?.valor.toString()


suspend {
    Log.i("fecha2", viewModel.uf2().toString())
}


        return binding.root

    }


}