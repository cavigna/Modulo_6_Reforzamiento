package com.example.indicesremoto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.example.indicesremoto.databinding.ActivityMainBinding
import com.example.indicesremoto.di.IndiceApplication
import com.example.indicesremoto.viewmodel.IndiceModelFactory
import com.example.indicesremoto.viewmodel.IndiceViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

   // val appContainer = (application as IndiceApplication).appContainer

    private val viewModel: IndiceViewModel by viewModels{
        IndiceModelFactory((application as IndiceApplication).appContainer.repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}