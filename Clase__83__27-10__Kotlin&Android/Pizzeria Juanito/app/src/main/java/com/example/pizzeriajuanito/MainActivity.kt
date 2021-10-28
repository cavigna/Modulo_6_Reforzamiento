package com.example.pizzeriajuanito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.pizzeriajuanito.databinding.ActivityMainBinding
import com.example.pizzeriajuanito.viewmodel.PizzaViewModel

class MainActivity : AppCompatActivity() {

    val viewModel: PizzaViewModel by viewModels() 

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}